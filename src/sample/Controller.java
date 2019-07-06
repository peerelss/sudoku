package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private Button mButton;
    @FXML
    TextField tf00, tf01, tf02, tf03, tf04, tf05, tf06, tf07, tf08,
            tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18,
            tf20, tf21, tf22, tf23, tf24, tf25, tf26, tf27, tf28,
            tf30, tf31, tf32, tf33, tf34, tf35, tf36, tf37, tf38,
            tf40, tf41, tf42, tf43, tf44, tf45, tf46, tf47, tf48,
            tf50, tf51, tf52, tf53, tf54, tf55, tf56, tf57, tf58,
            tf60, tf61, tf62, tf63, tf64, tf65, tf66, tf67, tf68,
            tf70, tf71, tf72, tf73, tf74, tf75, tf76, tf77, tf78,
            tf80, tf81, tf82, tf83, tf84, tf85, tf86, tf87, tf88;

    TextField[][] textFields;

    @FXML
    public void buttonClick(ActionEvent event) {
        System.out.println("* click *");
        initResult();
    }
    @FXML
    public void startButtonClick(ActionEvent event) {
         System.out.println("start calc");
         SudokuManager.getInstance().calc();
    }

    private void initResult() {
        TextField[][] textFields = {
                {tf00, tf01, tf02, tf03, tf04, tf05, tf06, tf07, tf08},
                {tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18},
                {tf20, tf21, tf22, tf23, tf24, tf25, tf26, tf27, tf28},
                {tf30, tf31, tf32, tf33, tf34, tf35, tf36, tf37, tf38},
                {tf40, tf41, tf42, tf43, tf44, tf45, tf46, tf47, tf48},
                {tf50, tf51, tf52, tf53, tf54, tf55, tf56, tf57, tf58},
                {tf60, tf61, tf62, tf63, tf64, tf65, tf66, tf67, tf68},
                {tf70, tf71, tf72, tf73, tf74, tf75, tf76, tf77, tf78},
                {tf80, tf81, tf82, tf83, tf84, tf85, tf86, tf87, tf88}
        };
        int[] results = new int[81];
        int k = 0;
        String str = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                str = textFields[i][j].getText();
                if (str.equals("")||str==null) {
                   results[k]=0;
                }else {
                    results[k] = Integer.valueOf(str);
                }
                k++;
            }
        }
        SudokuManager.getInstance().init(results);
    }
}