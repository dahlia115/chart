package survey.result.service;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import survey.dto.SurveyDTO;

public class resultServiceImpl implements resultSurvice {
	Parent root;

	public void setRoot(Parent root) {
		this.root = root;
		
	}

	public SurveyDTO result(Parent root) {
		SurveyDTO dto = new SurveyDTO();
		
		ArrayList<RadioButton>radioPlace = new ArrayList<>();
		for(int i=0;i<3;i++) {
			radioPlace.add((RadioButton) root.lookup("#place"+i)); 
			if(radioPlace.get(i).isSelected()) {
				dto.setPlace(i);
			}
		}
		ArrayList<RadioButton>radioAge = new ArrayList<>();
		for(int i = 0;i<4;i++) {
			radioAge.add((RadioButton) root.lookup("#age"+i));
			if(radioAge.get(i).isSelected()) {
				dto.setAge(i);
			}
		}
		RadioButton man = (RadioButton) root.lookup("#man");
		if(man.isSelected()) {
			dto.setGender(1);
		}else {
			dto.setGender(0);
		}
		return dto;
		
	}



	
	
}
