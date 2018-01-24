/**
 * 
 */
/**
 * @author MinSKim
 *
 */
package ui;


import edu.duke.FileResource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lottoCollection.LottoHistory;

public class MainRunner extends Application{
	
	public static LottoHistory LH;
	
	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainRunner.fxml"));
        primaryStage.setTitle("Lotto Hacker 1.0");
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
        
        buildLH();
        
	}
	
	public void buildLH() {
		FileResource file = new FileResource("data/lotto784.csv");
		setLH(new LottoHistory(file));
		System.out.println("");
		//uiController.setPromptText("Loading LottoHistory til turn "+LH.getMyHis().size());
	}

	public static LottoHistory getLH() {
		return LH;
	}

	public void setLH(LottoHistory lH) {
		LH = lH;
	}

}