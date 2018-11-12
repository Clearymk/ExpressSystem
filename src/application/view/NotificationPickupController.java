package application.view;

import java.util.List;

import application.dao.Select;
import application.model.OrderInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NotificationPickupController {
	@FXML
	private TableView<OrderInfo> resultTable;
	@FXML
	private TableColumn<OrderInfo, String> orderIDColumn;
	@FXML
	private TableColumn<OrderInfo, String> senderNameColumn;
	@FXML
	private TableColumn<OrderInfo, String> senderPhoneNumberColumn;
	@FXML
	private TableColumn<OrderInfo, String> recipientNameColumn;
	@FXML
	private TableColumn<OrderInfo, String> recipientPhoneNumberColumn;
	@FXML
	private TableColumn<OrderInfo, String> senderAddressColumn;
	@FXML
	private TableColumn<OrderInfo, String> recipientAddressColumn;

	private FeatureController controller = FeatureController.getController();
	private ObservableList<OrderInfo> infos = FXCollections.observableArrayList();
	private Select select = new Select();

	@FXML
	private void initialize() {
		query(controller.getMainApp().getUserLogin().getId());

		showTableView();
	}

	private void query(int staffID) {
		try {
			List<application.pojo.OrderInfo> list = select.selectOrderInfoByStaffID(staffID);
			for (application.pojo.OrderInfo orderInfo : list) {
				OrderInfo info = new OrderInfo(String.valueOf(orderInfo.getorderID()), orderInfo.getSenderName(),
						orderInfo.getSenderPhoneNumber(), orderInfo.getReceiverName(),
						orderInfo.getReceiverPhoneNumber(), orderInfo.getStartAddress(), orderInfo.getEndAddress());
				infos.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showTableView() {
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty());
		senderNameColumn.setCellValueFactory(cellData -> cellData.getValue().senderNameProperty());
		senderPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().senderPhoneNumberProperty());
		recipientNameColumn.setCellValueFactory(cellData -> cellData.getValue().recipientNameProperty());
		recipientPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().recipientPhoneNumberProperty());
		senderAddressColumn.setCellValueFactory(cellData -> cellData.getValue().senderAddressProperty());
		recipientAddressColumn.setCellValueFactory(cellData -> cellData.getValue().recipientAddressProperty());

		resultTable.setItems(infos);
	}
}
