package survey;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import chart.ChartService;
import chart.ChartServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import survey.database.DatabaseService;
import survey.database.DatabaseServiceImpl;
import survey.dto.SurveyDTO;
import survey.result.service.resultServiceImpl;
import survey.result.service.resultSurvice;


public class Controller implements Initializable {
	Parent root;
	DatabaseService db;
	resultSurvice rs;
	SurveyDTO dto;
	ChartService cs;
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	public void okProc() {//확인 버튼
		 dto = rs.result(root);
		 db.insertData(dto);
	}
	public void cancelProc() {//취소 버튼
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
	}
	public void resultProc() {//결과보기 버튼
		ArrayList<SurveyDTO> lists = db.selectdata();
		cs = new ChartServiceImpl();
		cs.viewChart(lists);
		
		
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cs = new ChartServiceImpl();
		rs = new resultServiceImpl();
		db = new DatabaseServiceImpl();
	}
}
