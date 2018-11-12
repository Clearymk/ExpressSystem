package application.util;

import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;

/**
 * 表单验证工具类
 * 
 * @author Clear
 *
 */
public class FormVaildateUtil<T extends TextInputControl> {
	private T[] requireControls;// 非空验证目标控件
	private ObservableList<Label> reqLabels = FXCollections.observableArrayList();
	private ObservableList<Label> regLabels = FXCollections.observableArrayList();
	public static final String BIGDECIMAL_REG = "^[+-]?\\d+(\\.\\d+)?$"; // BigDecimal类型数据的正则表达式
	public static final String CHINAMOBILENO_REG = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"; // 中国手机号码的正则表达式
	public static final String EMAIL_REG = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
	public static final String PASSWORD_REG = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
	
	/**
	 * 为表单添加非空验证
	 * 
	 * @param targetControls，目标表单数组
	 * @param errorTexts，错误提示文字数组
	 * @return，返回验证结果，只要出现一个表单为空，则返回为false
	 */
	public void installrequireValidation(T[] targetControls, String[] errorTexts) {

		// 初始化非空验证目标控件数组
		requireControls = targetControls;

		for (int i = 0, tarCount = targetControls.length; i < tarCount; i++) {
			Label requireLabel = new Label();
			requireLabel.setVisible(false);
			requireLabel.setText(errorTexts[i]);
			requireLabel.getStyleClass().add("error-text");// 设置错误提示信息的样式
			FormVaildateUtil.setTextLocation(targetControls[i], requireLabel);
			reqLabels.add(requireLabel);

			// 表单获取焦点时进行验证 
			int curIndex = i;
			targetControls[i].focusedProperty().addListener((obVal, oldVal, newVal) -> {
				if (newVal) {
					if ("".equals(targetControls[curIndex].getText())) {
						requireLabel.setVisible(true);
					} else {
						requireLabel.setVisible(false);
					}
				}
			});

			// 键入文字时实时验证
			targetControls[i].textProperty().addListener((obVal, oldVal, newVal) -> {

				if ("".equals(newVal)) {
					requireLabel.setVisible(true);
				} else {
					requireLabel.setVisible(false);
				}
			});
		}
	}

	public void confirmInfoValidation(T targetControls, T sourceControls, String errorTexts) {
		Label requireLabel = new Label();
		requireLabel.setVisible(false);
		requireLabel.setText(errorTexts);
		requireLabel.getStyleClass().add("error-text");// 设置错误提示信息的样式
		FormVaildateUtil.setTextLocation(targetControls, requireLabel);

		targetControls.focusedProperty().addListener((obVal, oldVal, newVal) -> {
			if (newVal) {
				System.out.println(sourceControls.getText());
				System.out.println(targetControls.getText());
				System.out.println(sourceControls.getText().equals(targetControls.getText()));
				if (sourceControls.getText() == null || targetControls.getText() == null) {
					requireLabel.setVisible(true);
				} else {
					if (sourceControls.getText().equals(targetControls.getText())) {
						requireLabel.setVisible(false);
					} else {
						requireLabel.setVisible(true);
					}
				}

			}
		});
		
		targetControls.textProperty().addListener((obVal, oldVal, newVal) -> {

			if (sourceControls.getText() == null || targetControls.getText() == null) {
				requireLabel.setVisible(true);
			} else {
				if (sourceControls.getText().equals(targetControls.getText())) {
					requireLabel.setVisible(false);
				} else {
					requireLabel.setVisible(true);
				}
			}
		});
	}

	/**
	 * 为表单添加正则验证
	 * 
	 * @param targetControls,目标表单数组
	 * @param regType，正则验证类型
	 * @param errorText，错误提示文字
	 * @return，只要有一个表单未通过正则，则返回就为false
	 */
	public void installRegularValidation(T[] targetControls, String regType, String[] errorTexts) {

		for (int i = 0, tarCount = targetControls.length; i < tarCount; i++) {
			Label regLabel = new Label();
			regLabel.setVisible(false);
			regLabel.setText(errorTexts[i]);
			regLabel.getStyleClass().add("error-text");// 设置错误提示信息的样式
			FormVaildateUtil.setTextLocation(targetControls[i], regLabel);
			regLabels.add(regLabel);

			int curIndex = i;
			targetControls[i].textProperty().addListener((obVal, oldVal, newVal) -> {

				// 表单为空时不进行正则验证
				if (!"".equals(newVal) && !Pattern.matches(regType, targetControls[curIndex].getText())) {
					regLabel.setVisible(true);
				} else {
					regLabel.setVisible(false);
				}
			});
		}
	}

	/**
	 * 验证当前所有目标控件
	 * 
	 * @param targetControls,当前所有目标控件
	 * @return
	 */
	public boolean isvalid() {

		/* 触发初始非空验证 */
		for (int i = 0, reqCount = reqLabels.size(); i < reqCount; i++) {

			if (0 == requireControls[i].getLength()) {
				reqLabels.get(i).setVisible(true);
			} else {
				reqLabels.get(i).setVisible(false);
			}

		}

		/* 检验所有指定控件是否通过验证 */
		for (int i = 0, reqLabelSize = reqLabels.size(); i < reqLabelSize; i++) {
			if (reqLabels.get(i).isVisible()) {
				return false;
			}
		}
		for (int i = 0, regLabelSize = regLabels.size(); i < regLabelSize; i++) {
			if (regLabels.get(i).isVisible()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 向页面添加Label
	 * 
	 * @param target，目标控件
	 * @param errorLabel，错误信息Label
	 */
	private static void setTextLocation(Node target, Label errorLabel) {
		Pane nodeContainer = (Pane) target.getParent();
		nodeContainer.getChildren().add(errorLabel);

		final double Y_OFFSET = 30.0;
		errorLabel.setLayoutX(target.getLayoutX());
		errorLabel.setLayoutY(target.getLayoutY() + Y_OFFSET);

	}
}