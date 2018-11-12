package application.view;

import application.dao.Select;
import application.model.RouterTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DriverTaskController {
	@FXML
	private TableView<RouterTable> taskTable;
	@FXML
	private TableColumn<RouterTable, String> orderIDTableColumn;
	@FXML
	private TableColumn<RouterTable, String> conveyanceIDTableColumn;
	@FXML
	private TableColumn<RouterTable, String> startAddressColumn;
	@FXML
	private TableColumn<RouterTable, String> targeAddressColumn;
	@FXML
	private TableColumn<RouterTable, String> dispatchCenterIDColumn;
	
	private ObservableList<RouterTable> tables = FXCollections.observableArrayList();
	private Select select = new Select();
	private FeatureController controller = FeatureController.getController();
	
	private void showTableView() {
		orderIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().expressIDProperty());
		conveyanceIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().conveyanceIDProperty());
		startAddressColumn.setCellValueFactory(cellData -> cellData.getValue().startAddressProperty());
		targeAddressColumn.setCellValueFactory(cellData -> cellData.getValue().targeAddressProperty());
		dispatchCenterIDColumn.setCellValueFactory(cellData -> cellData.getValue().dispatchCenterIDProperty());
	
		taskTable.setItems(tables);
	}
	
	@FXML
	private void initialize() {
		tables.clear();
		queryDriverTask();
		showTableView();
	}
	
	//TODO
	private void queryDriverTask() {
		try {
			select.selectDispatchInfoByStaffID(controller.getMainApp().getUserLogin().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
