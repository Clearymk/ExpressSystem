package application.view;

import java.time.LocalDate;
import java.util.Arrays;

import application.dao.Select;
import application.model.ViewFeedbackForm;
import application.util.AlertUtil;
import application.util.DateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TrackOrderController {
	@FXML
	private TextField orderIDField;
	@FXML
	private TableView<ViewFeedbackForm> resultTable;
	@FXML
	private TableColumn<ViewFeedbackForm, String> orderIDColumn;
	@FXML
	private TableColumn<ViewFeedbackForm, String> locationColumn;
	@FXML
	private TableColumn<ViewFeedbackForm, String> orderStateColumn;
	@FXML
	private TableColumn<ViewFeedbackForm, LocalDate> surveyTimeColumn;

	private AlertUtil util = AlertUtil.getAlertUtil();
	private ObservableList<ViewFeedbackForm> forms = FXCollections.observableArrayList();
	private Select select = new Select();

	@FXML
	private void trackOrderAction() {
		forms.clear();
		checkOrderInfo(orderIDField.getText());
		showTableView();
		util.showMessage(AlertType.ERROR);
	}

	private void checkOrderInfo(String orderInfo) {
		String handerMessage = "";
		String errorMessage = "";

		if ("".equals(orderInfo) || orderInfo == null) {
			handerMessage = "����������";
			errorMessage = "������Ϊ��";
		} else {
			String[] orders = orderInfo.split(" +");

			if (orders.length > 5) {
				handerMessage = "���������붩����";
				errorMessage = "���붩���Ŵ���5��";
			} else {
				System.out.println(orders.length);
				System.out.println(Arrays.toString(orders));

				ViewFeedbackForm form;

				for (String order : orders) {
					form = query(order);
					if (form != null) {
						forms.add(form);
					}
				}

				if (forms.size() == 0) {
					handerMessage = "�����Ƿ��������";
					errorMessage = "δ��ѯ������";
				} else if (forms.size() < orders.length) {
					handerMessage = "�����Ƿ��������";
					errorMessage = "δ��ѯ��ȫ������";
				}
			}
		}

		util.setHanderMessage(handerMessage);
		util.setMessage(errorMessage);
	}

	private void showTableView() {
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
		locationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
		orderStateColumn.setCellValueFactory(cellData -> cellData.getValue().orderStateProperty());
		surveyTimeColumn.setCellValueFactory(cellData -> cellData.getValue().surveyTimeProperty());

		resultTable.setItems(forms);
	}

	private ViewFeedbackForm query(String orderID) {
		try {
			application.pojo.ViewFeedbackForm form = select.selectSurveyFeedbackFormByOrderID(orderID);
			
			System.out.println(form.getviewDate());
			return new ViewFeedbackForm(form.getOrderID(), form.getwarehouseLocation(), form.getOrderState(),
					DateUtil.parse(form.getviewDate()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
