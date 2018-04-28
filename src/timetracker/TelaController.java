/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetracker;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author gus
 */
public class TelaController {
    @FXML Label tempo;
    @FXML BorderPane pane;
    
    StopWatch stopwatch;
    Date dataInicio;
    
    SimpleDateFormat sdfTime;
    
    boolean pausado = false;
    
    @FXML
    public void initialize() {
        // Inicializar a label com a data atual
        sdfTime = new SimpleDateFormat("HH:mm:ss");
        
        stopwatch = new StopWatch();
        
        pane.setCenter(stopwatch);
    }
    
    private void startTimer() {
        if (!pausado)
            resetTimer();
        
        stopwatch.play();
        pausado = false;
    }
    
    private void pauseTimer() {
        stopwatch.pause();
        pausado = true;
    }
    
    private void resetTimer() {
        stopwatch.clear();
        pauseTimer();
        dataInicio = new Date();
    }
    
    private String getTime() {
        String time = stopwatch.getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(dataInicio);
        
        Date timeDate;
        
        try {
            timeDate = sdfTime.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        
        c.add(Calendar.HOUR, timeDate.getHours());
        c.add(Calendar.MINUTE, timeDate.getMinutes());
        c.add(Calendar.SECOND, timeDate.getSeconds());
        
        return sdfTime.format(c.getTime());
    }
    
    private String getDiaSemana(Calendar calendar) {
//        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
//            
//        }

        return "";
    }
    
    @FXML
    public void onClickPlay() {
        startTimer();
    }
    
    @FXML
    public void onClickReset() {
        resetTimer();
    }
    
    @FXML
    public void onClickPause() {
        pauseTimer();
    }
    
    @FXML
    public void onClickClipboard() {
        String text = "Sexta	" + sdfTime.format(dataInicio) + "	" + getTime();
        
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
        System.out.println(text);
    }
    
    /**
    // Pane em que o CoffeePane será contido
    @FXML Pane parentCoffeePane;
    // Campo para digitação da medida (em ml) do copo
    @FXML TextField medidaCopo;
    // Label com as informações sobre a ingestão diária
    @FXML Label labelInfoIngestao;
    // Label com a data atual
    @FXML Label labelDataAtual;
    
    // Gerencia toda a lógica de clicar e medir a quantidade de café no copo
    CoffeePane coffeePane;
    // Quantidade de copos ingeridos
    int coposBebeu = 0;
    // Tamanho do copo atual
    double tamCopo = 0d;
    
    // POJO usado para mapear o registro de ingestão diária no banco de dados
    Registro registro;
    // POJO usado para armazenar o último tamanho de copo informado
    Configuracao configTamanhoCopo;
    
    
    
    @FXML
    public void confirmar() {
        // Arrumar confirmar não vai
        if (!medidaCopo.getText().isEmpty()) {
            atualizarTamanhoCopo();
            double qtdIngerida = tamCopo * (coffeePane.pixelsPreenchidos / (double) coffeePane.height);
            
            registro.setMlIngerido(registro.getMlIngerido() + qtdIngerida);
            DaoRegistro.merge(registro);
            
            atualizarCoposBebeu();
            atualizarLabelIngestao();
            
//            List<Registro> list = DaoRegistro.findAll();
//            for (Registro reg : list) {
//                System.out.println("id: " + reg.getId() + ", mlIngerido: " + reg.getMlIngerido() + ", data: " + reg.getData());
//            }
        }
    }
    
    @FXML
    public void atualizarTamanhoCopo() {
        tamCopo = Double.parseDouble(medidaCopo.getText().replaceAll("[^\\d.]", ""));
        configTamanhoCopo.setValor(String.valueOf(tamCopo));
        DaoConfiguracao.merge(configTamanhoCopo);
    }
    
    private void atualizarCoposBebeu() {
        atualizarTamanhoCopo();
        coposBebeu = (int) Math.floor(registro.getMlIngerido() / tamCopo);
    }
    
    private void atualizarLabelIngestao() {
        double totalIngestao = registro.getMlIngerido();
        String unidadeMedidaIngestao = "ml";
        if (totalIngestao > 1000) {
            totalIngestao /= 1000;
            unidadeMedidaIngestao = "L";
        } else {
            totalIngestao = (int)totalIngestao;
        }
        labelInfoIngestao.setText(String.format("%1$d copo(s) de %2$dml | %3$.1f%4$s no total", (int)coposBebeu, (int)tamCopo, totalIngestao, unidadeMedidaIngestao));
    }
    
    private void pegarValoresBanco() {
        registro = DaoRegistro.find(new Date());
        if (registro.getId() == 0) {
            registro.setData(new Date());
            registro.setId(DaoRegistro.merge(registro));            
        }
        Registro reg = registro;
        
        configTamanhoCopo = DaoConfiguracao.find("tamCopo");
        if (configTamanhoCopo.getId() == 0) {
            configTamanhoCopo.setChave("tamCopo");
            configTamanhoCopo.setValor(String.valueOf(tamCopo));
            configTamanhoCopo.setId(DaoConfiguracao.merge(configTamanhoCopo));
        }
    }
    */
}
