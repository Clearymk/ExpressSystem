package application.view;

import application.dao.Login;
import application.model.Driver;
import application.model.Manager;
import application.model.User;
import application.model.UserLogin;
import application.model.Viewer;
import application.model.Waiter;
import application.pojo.LoginUser;
import application.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UserLoginController {
	@FXML
	private Button loginButton;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;

	private FeatureController controller = FeatureController.getController();
	private AlertUtil util = AlertUtil.getAlertUtil();
	private Login login = new Login();

	@FXML
	public void loginAction() {
		if (checkLogin(usernameField.getText(), passwordField.getText())) {
			controller.getMainApp().setUserLogin(login(usernameField.getText(), passwordField.getText()));

			controller.getMainApp().loadFunctionView();
			controller.getMainApp().loadDefaultFuctionView();
		} else {
			util.showMessage(AlertType.ERROR);
		}
	}

	public boolean checkLogin(String username, String password) {
		String handerMessage = "";
		String errorMessage = "";
		boolean flag = true;

		if (username == null || username.length() == 0) {
			handerMessage += "用户名为空\n";
			flag = false;
		}

		if (password == null || password.length() == 0) {
			handerMessage += "密码为空\n";
			flag = false;
		}

		errorMessage += "请输入用户名或密码";

		if (flag == true) {
			if (login(username, password) == null) {
				errorMessage = "请检查用户名或密码是否输入正确";
				handerMessage = "未查询到此用户";
				flag = false;
			}
		}

		util.setHanderMessage(handerMessage);
		util.setMessage(errorMessage);

		return flag;
	}

	public UserLogin login(String username, String password) {
		try {
			LoginUser user = login.login(username, password);
			if (user.getClass().getSimpleName().equals("User")) {
				User u = new User();
				u.setId(user.getLoginUserID());
				return u;
			} else if (user.getClass().getSimpleName().equals("Viewer")) {
				Viewer v = new Viewer();
				v.setId(user.getLoginUserID());
				return v;
			} else if (user.getClass().getSimpleName().equals("Waiter")) {
				Waiter w = new Waiter();
				w.setId(user.getLoginUserID());
				return w;
			} else if (user.getClass().getSimpleName().equals("Driver")) {
				Driver d = new Driver();
				d.setId(user.getLoginUserID());
				return d;
			} else if (user.getClass().getSimpleName().equals("Manager")) {
				Manager m = new Manager();
				m.setId(user.getLoginUserID());
				return m;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@FXML
	private void registerAction() {
		controller.getMainApp().loadRegisterView();
	}
}
