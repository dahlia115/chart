package survey.database;

import java.util.ArrayList;

import survey.dto.SurveyDTO;

public interface DatabaseService {
	public void insertData(SurveyDTO dto);
	public ArrayList<SurveyDTO> selectdata();
}
