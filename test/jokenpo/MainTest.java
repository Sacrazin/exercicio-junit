package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes do Jogo Jokenpo")
public class MainTest {

    private Main jogo;

    @BeforeEach
    public void setUp() {
        jogo = new Main();
    }

    @Test
    @DisplayName("Deve retornar 0 quando houver empate")
    public void testEmpate() {
        // 1 = Papel, 2 = Pedra, 3 = Tesoura
        assertEquals(0, jogo.jogar(1, 1), "Papel vs Papel deve empatar");
        assertEquals(0, jogo.jogar(2, 2), "Pedra vs Pedra deve empatar");
        assertEquals(0, jogo.jogar(3, 3), "Tesoura vs Tesoura deve empatar");
    }

    @Test
    @DisplayName("Deve retornar 1 quando o Jogador 1 vencer")
    public void testJogador1Vence() {
        assertEquals(1, jogo.jogar(1, 2), "Papel (1) ganha de Pedra (2)");
        assertEquals(1, jogo.jogar(2, 3), "Pedra (2) ganha de Tesoura (3)");
        assertEquals(1, jogo.jogar(3, 1), "Tesoura (3) ganha de Papel (1)");
    }

    @Test
    @DisplayName("Deve retornar 2 quando o Jogador 2 vencer")
    public void testJogador2Vence() {
        assertEquals(2, jogo.jogar(2, 1), "Pedra (2) perde para Papel (1)");
        assertEquals(2, jogo.jogar(3, 2), "Tesoura (3) perde para Pedra (2)");
        assertEquals(2, jogo.jogar(1, 3), "Papel (1) perde para Tesoura (3)");
    }

    @Test
    @DisplayName("Deve retornar -1 quando houver opções inválidas")
    public void testOpcoesInvalidas() {
        // Limites inferiores (menor ou igual a 0)
        assertEquals(-1, jogo.jogar(0, 2), "Jogador 1 escolhendo 0 é inválido");
        assertEquals(-1, jogo.jogar(2, -1), "Jogador 2 escolhendo número negativo é inválido");

        // Limites superiores (maior que 3)
        assertEquals(-1, jogo.jogar(4, 1), "Jogador 1 escolhendo 4 é inválido");
        assertEquals(-1, jogo.jogar(2, 5), "Jogador 2 escolhendo 5 é inválido");
    }
}