package application;

import java.io.IOException;

import application.model.Employee;
import application.model.UserFunction;
import application.model.UserLogin;
import application.view.EmployeeEditDialogController;
import application.view.FeatureController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {
	private Stage primaryStage;
	private Stage registerStage;
	private Stage successStage;
	private BorderPane rootLayout;
	private UserLogin userLogin;

	private ObservableList<UserFunction> functionData = FXCollections.observableArrayList();
	private FeatureController controller = FeatureController.getController();

	public MainApp() {
		functionData.add(new UserFunction("订单追踪", "TrackOrder"));
		functionData.add(new UserFunction("我要寄件", "CreateOrder"));
		functionData.add(new UserFunction("收费标准查询", "CheckCharges"));
		functionData.add(new UserFunction("管理员工", "ManageEmployee"));
		functionData.add(new UserFunction("司机当前任务", "DriverTask"));
		functionData.add(new UserFunction("用户反馈", "UserFeedBack"));
		functionData.add(new UserFunction("填写检视反馈单", "ViewFeedBack"));
		functionData.add(new UserFunction("提醒收货", "NotificationPickup"));
	}

	public ObservableList<UserFunction> getFunctionData() {
		return functionData;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ExpressSystem");
		controller.setMainApp(this);

		initRootLayout();
		loadLoginView();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadLoginView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/UserLogin.fxml"));
			AnchorPane loginView = loader.load();

			rootLayout.setCenter(loginView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadFunctionView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/" + userLogin.getClass().getSimpleName() + "Function.fxml"));
			
			AnchorPane functionView = (AnchorPane) loader.load();
			rootLayout.setCenter(functionView);
			functionView.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadDefaultFuctionView() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TrackOrder.fxml"));
			AnchorPane trackView;
			trackView = (AnchorPane) loader.load();

			rootLayout.setRight(trackView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadSelectFunctionView(String functionCode) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/" + functionCode + ".fxml"));
			AnchorPane anchorPane = loader.load();
			rootLayout.setRight(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAutoTransferWeight() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AutoTransferWeight.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Stage transferWeightStage = new Stage();
			transferWeightStage.setTitle("计算重量");
			transferWeightStage.initOwner(primaryStage);

			Scene scene = new Scene(anchorPane);
			transferWeightStage.setScene(scene);

			transferWeightStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadRegisterView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/UserRegist.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			registerStage = new Stage();
			registerStage.setTitle("用户注册");
			registerStage.initOwner(primaryStage);

			Scene scene = new Scene(anchorPane);
			registerStage.setScene(scene);

			registerStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean showPersonEditDialog(Employee employee) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EmployeeEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EmployeeEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setEmployee(employee);

			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void showAboutDialog() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AboutDialog.fxml"));
			AnchorPane aboutPage = (AnchorPane) loader.load();

			Stage aboutStage = new Stage();
			aboutStage.setTitle("关于该软件");
			aboutStage.initOwner(primaryStage);

			Scene scene = new Scene(aboutPage);
			aboutStage.setScene(scene);

			aboutStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showSuccessDialog() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/UserFeedBackSuccess.fxml"));
			AnchorPane aboutPage = (AnchorPane) loader.load();

			successStage = new Stage();
			successStage.setTitle("提交反馈单成功");
			successStage.initOwner(primaryStage);

			Scene scene = new Scene(aboutPage);
			successStage.setScene(scene);

			successStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void killUserFeedBackSuccessStage() {
		if (successStage != null) {
			successStage.close();
		}
	}

	public void killRegistStage() {
		if (registerStage != null) {
			registerStage.close();
		}
	}

	public void killPrimaryStage() {
		this.primaryStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
}
