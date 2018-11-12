package application.view;

import application.dao.Select;
import application.model.SearchChargeList;
import application.pojo.ChargeInfo;
import application.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CheckChargesController {
	@FXML
	private TextField originPlaceField;
	@FXML
	private TextField destinationField;
	@FXML
	private TextField weightField;
	@FXML
	private Label weightLabel;
	@FXML
	private Label transportationTimeLabel;
	@FXML
	private Label feeLabel;
	@FXML
	private Label autoTransferLabel;

	private AlertUtil util = AlertUtil.getAlertUtil();
	private FeatureController controller = FeatureController.getController();
	private Select select = new Select();

	@FXML
	private void searchChargeAction() {
		showCharge();
	}

	@FXML
	private void autoTransferWeight() {
		controller.getMainApp().showAutoTransferWeight();
	}
	
	private SearchChargeList searchCharge(String originPlace, String destination, int weight) {
		SearchChargeList chargeList = null;
		try {
			ChargeInfo info = select.selectChargeInfoByReachableList(originPlaceField.getText(), destinationField.getText());
			chargeList = new SearchChargeList(Double.valueOf(weightField.getText()), info.getPredictTime(),
					info.getTransportCost() * Double.valueOf(weightField.getText()));
		} catch (Exception e) {
			e.printStackTrace();
			AlertUtil util = AlertUtil.getAlertUtil();
			util.setHanderMessage("未查询到结果");
			util.setMessage("尝试查询路线其他信息");
			util.showMessage(AlertType.ERROR);
		}

		return chargeList;
	}

	private void showCharge() {
		try {
			SearchChargeList list = searchCharge(originPlaceField.getText(), destinationField.getText(),
					Integer.parseInt(weightField.getText()));
			
			weightLabel.setText(String.valueOf(list.getWeight()));
			transportationTimeLabel.setText(String.valueOf(list.getTransportationTime()));
			feeLabel.setText(String.valueOf(list.getFee()));
		} catch (NumberFormatException e) {
			util.setHanderMessage("输入错误的重量");
			util.setMessage("请重新输入");
			util.showMessage(AlertType.ERROR);
		}

	}
}
