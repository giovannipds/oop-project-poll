/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.*;
import java.util.*;

/**
 * Janela que exibe o resultado percentual da votação on-line. Esta tela é
 * atualizada a cada novo voto a uma opção da enquete.
 *
 * @author giovannipds
 */
public class TelaResultadoPercentual extends Window {

    private Map labels = new HashMap();

    public TelaResultadoPercentual(Frame parent) {
        super(parent);
        this.setSize(180, 120);
        this.setLayout(new GridLayout(0, 2));
        // Grid com qualquer numero
        // de linhas e uma coluna
        this.add(new Label("Percentual"));
        this.add(new Label());
    }

    /**
     * Recebe a lista de opcoes inicial
     */
    public void inicializar(Iterator opcoes) {
        String opcao;
        Label label;
        Label votos;
        while (opcoes.hasNext()) {
            opcao = (String) opcoes.next();
            if (!labels.containsKey(opcao)) {
                label = new Label(opcao + " - ");
                votos = new Label("" + 0 + "%");
                labels.put(opcao, votos);
                this.add(label);
                this.add(votos);
            }
        }
    }

    public void novoVoto(String opcao, int nvotos, int total) {
        Label votos;
        votos = (Label) labels.get(opcao);
        votos.setText("" + (nvotos * 100 / total) + " %");
    }

}
