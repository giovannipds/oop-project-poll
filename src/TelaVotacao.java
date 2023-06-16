/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.List;

/**
 * Tela para cadastro de votos.
 *
 * @author giovannipds
 */
public class TelaVotacao extends Frame implements ActionListener {

    private TelaResultado telaResult;
    private TelaResultadoPercentual telaResultPerc;
    private Map opcoes;
    private List listaOpcoes; // para obter as opções em ordem

    public TelaVotacao() {
        super("Tela de Votação - Enquete");
        telaResult = new TelaResultado(this);
        telaResult.setLocation(120, 5);
        telaResultPerc = new TelaResultadoPercentual(this);
        telaResultPerc.setLocation(250, 5);
        listaOpcoes = new Vector();
        this.opcoes = new HashMap();
        this.adicionaOpcao("Opção 1");
        this.adicionaOpcao("Opção 2");
        this.adicionaOpcao("Opção 3");
        this.adicionaOpcao("Opção 4");
        criarBotoes();
        telaResult.inicializar(listaOpcoes.iterator());
        telaResultPerc.inicializar(listaOpcoes.iterator());
        this.setSize(100, 120);
        this.setLayout(new GridLayout(0, 1)); // Grid com qualquer numero
        // de linhas e uma coluna
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                e.getWindow().hide();
                System.exit(0);
            }
        });
        this.show();
        telaResult.show();
        telaResultPerc.show();
    }

    private void adicionaOpcao(String opcao) {
        listaOpcoes.add(opcao);
        this.opcoes.put(opcao, new Integer(0));
    }

    public void criarBotoes() {
        Iterator it = listaOpcoes.iterator();
        String opcao;
        Button botao;
        while (it.hasNext()) {
            opcao = (String) it.next();
            botao = new Button(opcao);
            botao.setActionCommand(opcao);
            botao.addActionListener(this);
            this.add(botao);
        }
    }

    /**
     * Executado ao clicar nos botões
     */
    public void actionPerformed(ActionEvent event) {
        String opcao = event.getActionCommand();
        this.votar(opcao);//incrementando o voto
        // Atualizando a tela de resultados absolutos
        telaResult.novoVoto(opcao, getVotos(opcao));
        // Atualizando a tela de resultados percentuais
        telaResultPerc.novoVoto(opcao, getVotos(opcao), getTotalVotos());
    }

    /**
     * Incrementa o voto da opção entrada
     */
    public void votar(String opcao) {
        int votoAtual = ((Integer) this.opcoes.get(opcao)).intValue();
        this.opcoes.put(opcao, new Integer(++votoAtual));
    }

    /**
     * Retorna a soma dos votos de todas as opções da enquete
     *
     * @return int soma dos votos de todas as opções da enquete
     */
    public int getTotalVotos() {
        Iterator votos = this.opcoes.values().iterator();
        int total = 0;
        while (votos.hasNext()) {
            total += ((Integer) votos.next()).intValue();
        }
        return total;
    }

    /**
     * Retorna a quantidade de votos de uma opção individual
     */
    public int getVotos(String opcao) {
        return ((Integer) this.opcoes.get(opcao)).intValue();
    }

}
