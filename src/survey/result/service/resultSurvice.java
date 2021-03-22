package survey.result.service;

import javafx.scene.Parent;
import survey.dto.SurveyDTO;

public interface resultSurvice {
	public void setRoot(Parent root);
	public SurveyDTO result(Parent root);
}
