import threading  # Biblioteca para trabalhar com threads (execuções simultâneas)
import random     # Biblioteca para gerar números aleatórios
import time       # Biblioteca para medir tempo e usar pausas (sleep)

# Classe que representa cada filósofo no problema do jantar dos filósofos
class FilosofoJantar(threading.Thread):  # Herda de Thread para rodar em paralelo
    contagem_refeicoes = []            # Lista para contar quantas vezes cada filósofo comeu
    tempo_comendo_ms = []              # Lista para armazenar o tempo total que cada filósofo passou comendo
    semafaro_mesa = threading.Semaphore(2)  # Semáforo que permite apenas 2 filósofos à mesa ao mesmo tempo
   
    # Lista com nomes de filósofos reais
    nomes_filosofos = [
        "Filósofo 1",
        "Filósofo 2",
        "Filósofo 3",
        "Filósofo 4",
        "Filósofo 5"
    ]

    # Construtor da classe
    def __init__(self, indice: int, garfo_esquerdo: threading.Lock, garfo_direito: threading.Lock):
        super().__init__()  # Inicializa a thread
        self.indice = indice  # Índice do filósofo
        self.garfo_esquerdo = garfo_esquerdo  # Garfo à esquerda do filósofo
        self.garfo_direito = garfo_direito    # Garfo à direita do filósofo
        self.random = random.Random()         # Instância de gerador de números aleatórios
        self.em_loop = True                   # Controle para parar o loop do filósofo
        self.nome = self.nomes_filosofos[indice]  # Nome correspondente ao índice

    # Método que define o comportamento da thread
    def run(self):
        while self.em_loop:  # Enquanto não for parado...
            print(f"[{self.nome}] Pensando...")  # Filósofo começa pensando
            time.sleep(self.random.randint(0, 1))  # Aguarda um tempo aleatório curto

            FilosofoJantar.semafaro_mesa.acquire()  # Tenta entrar na "mesa" (máx. 2 filósofos simultâneos)
            try:
                # Tenta pegar o garfo esquerdo com tempo limite
                esquerda = self.garfo_esquerdo.acquire(timeout=0.01)
                if esquerda:
                    print(f"[{self.nome}] Pegou o garfo esquerdo")
                else:
                    print(f"[{self.nome}] Falha ao pegar o garfo esquerdo")

                # Tenta pegar o garfo direito com tempo limite
                direita = self.garfo_direito.acquire(timeout=0.01)
                if direita:
                    print(f"[{self.nome}] Pegou o garfo direito")
                else:
                    print(f"[{self.nome}] Falha ao pegar o garfo direito")

                # Se conseguiu os dois garfos, come
                if esquerda and direita:
                    print(f"[{self.nome}] Tem os dois garfos, começando a comer")
                    t0 = time.perf_counter()  # Marca o tempo inicial
                    time.sleep(self.random.uniform(0, 1))  # Come por tempo aleatório
                    duracao = (time.perf_counter() - t0) * 1000  # Calcula duração em milissegundos

                    FilosofoJantar.contagem_refeicoes[self.indice] += 1     # Incrementa a quantidade de refeições
                    FilosofoJantar.tempo_comendo_ms[self.indice] += duracao  # Soma o tempo total comendo

                    print(f"[{self.nome}] Terminou de comer ({duracao:.2f} ms)")

                    # Libera os garfos
                    self.garfo_direito.release()
                    self.garfo_esquerdo.release()

                else:
                    # Se só conseguiu um garfo, solta e volta a pensar
                    if esquerda and not direita:
                        print(f"[{self.nome}] Só ficou com o garfo esquerdo — largando e voltando a pensar")
                        self.garfo_esquerdo.release()
                    elif direita and not esquerda:
                        print(f"[{self.nome}] Só ficou com o garfo direito — largando e voltando a pensar")
                        self.garfo_direito.release()
                    else:
                        print(f"[{self.nome}] Não conseguiu nenhum garfo — voltando a pensar")
            finally:
                FilosofoJantar.semafaro_mesa.release()  # Libera vaga na mesa

    # Método para parar o filósofo
    def parar(self):
        self.em_loop = False  # Sinaliza para sair do loop

# Função que simula o jantar
def simular_jantar(duracao_segundos: float = 10):
    N = 5  # Número de filósofos (e de garfos)

    # Inicializa listas de estatísticas com valores zerados
    FilosofoJantar.contagem_refeicoes = [0] * N
    FilosofoJantar.tempo_comendo_ms = [0.0] * N

    # Cria um garfo (lock) para cada posição na mesa
    garfos = [threading.Lock() for _ in range(N)]

    # Cria os filósofos, cada um com seu garfo esquerdo e direito
    filosofos = [FilosofoJantar(i, garfos[i], garfos[(i + 1) % N]) for i in range(N)]

    # Início da simulação
    print("\n" + "=" * 50)
    print(" INÍCIO DA SIMULAÇÃO DO JANTAR DOS FILÓSOFOS ".center(50, "="))
    print("=" * 50 + "\n")

    t_inicio = time.perf_counter()  # Marca o início do tempo de execução
    for f in filosofos:
        f.start()  # Inicia a thread de cada filósofo

    time.sleep(duracao_segundos)  # Executa por tempo definido

    for f in filosofos:
        f.parar()  # Manda parar
    for f in filosofos:
        f.join()   # Aguarda cada thread terminar

    duracao_total = time.perf_counter() - t_inicio  # Calcula tempo total da simulação

    # Exibe estatísticas ao final
    print("\n" + "-" * 50)
    print(f"Tempo total de execução: {duracao_total:.2f} segundos")
    print("Estatísticas por filósofo:")
    print(f"{'Filósofo':<12} {'Refeições':<10} {'Tempo (ms)':<12}")
    print("-" * 50)
    for i in range(N):
        r = FilosofoJantar.contagem_refeicoes[i]
        tm = FilosofoJantar.tempo_comendo_ms[i]
        print(f"{FilosofoJantar.nomes_filosofos[i]:<12} {r:<10} {tm:<12.2f}")
    print("-" * 50)

# Executa a simulação se for o script principal
if __name__ == "__main__":
    simular_jantar(duracao_segundos=10)
