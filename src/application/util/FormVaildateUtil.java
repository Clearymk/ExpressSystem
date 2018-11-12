package application.util;

import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;

/**
 * ����֤������
 * 
 * @author Clear
 *
 */
public class FormVaildateUtil<T extends TextInputControl> {
	private T[] requireControls;// �ǿ���֤Ŀ��ؼ�
	private ObservableList<Label> reqLabels = FXCollections.observableArrayList();
	private ObservableList<Label> regLabels = FXCollections.observableArrayList();
	public static final String BIGDECIMAL_REG = "^[+-]?\\d+(\\.\\d+)?$"; // BigDecimal�������ݵ�������ʽ
	public static final String CHINAMOBILENO_REG = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"; // �й��ֻ������������ʽ
	public static final String EMAIL_REG = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
	public static final String PASSWORD_REG = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
	
	/**
	 * Ϊ����ӷǿ���֤
	 * 
	 * @param targetControls��Ŀ�������
	 * @param errorTexts��������ʾ��������
	 * @return��������֤�����ֻҪ����һ����Ϊ�գ��򷵻�Ϊfalse
	 */
	public void installrequireValidation(T[] targetControls, String[] errorTexts) {

		// ��ʼ���ǿ���֤Ŀ��ؼ�����
		requireControls = targetControls;

		for (int i = 0, tarCount = targetControls.length; i < tarCount; i++) {
			Label requireLabel = new Label();
			requireLabel.setVisible(false);
			requireLabel.setText(errorTexts[i]);
			requireLabel.getStyleClass().add("error-text");// ���ô�����ʾ��Ϣ����ʽ
			FormVaildateUtil.setTextLocation(targetControls[i], requireLabel);
			reqLabels.add(requireLabel);

			// ����ȡ����ʱ������֤ 
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

			// ��������ʱʵʱ��֤
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
		requireLabel.getStyleClass().add("error-text");// ���ô�����ʾ��Ϣ����ʽ
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
	 * Ϊ�����������֤
	 * 
	 * @param targetControls,Ŀ�������
	 * @param regType��������֤����
	 * @param errorText��������ʾ����
	 * @return��ֻҪ��һ����δͨ�������򷵻ؾ�Ϊfalse
	 */
	public void installRegularValidation(T[] targetControls, String regType, String[] errorTexts) {

		for (int i = 0, tarCount = targetControls.length; i < tarCount; i++) {
			Label regLabel = new Label();
			regLabel.setVisible(false);
			regLabel.setText(errorTexts[i]);
			regLabel.getStyleClass().add("error-text");// ���ô�����ʾ��Ϣ����ʽ
			FormVaildateUtil.setTextLocation(targetControls[i], regLabel);
			regLabels.add(regLabel);

			int curIndex = i;
			targetControls[i].textProperty().addListener((obVal, oldVal, newVal) -> {

				// ��Ϊ��ʱ������������֤
				if (!"".equals(newVal) && !Pattern.matches(regType, targetControls[curIndex].getText())) {
					regLabel.setVisible(true);
				} else {
					regLabel.setVisible(false);
				}
			});
		}
	}

	/**
	 * ��֤��ǰ����Ŀ��ؼ�
	 * 
	 * @param targetControls,��ǰ����Ŀ��ؼ�
	 * @return
	 */
	public boolean isvalid() {

		/* ������ʼ�ǿ���֤ */
		for (int i = 0, reqCount = reqLabels.size(); i < reqCount; i++) {

			if (0 == requireControls[i].getLength()) {
				reqLabels.get(i).setVisible(true);
			} else {
				reqLabels.get(i).setVisible(false);
			}

		}

		/* ��������ָ���ؼ��Ƿ�ͨ����֤ */
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
	 * ��ҳ�����Label
	 * 
	 * @param target��Ŀ��ؼ�
	 * @param errorLabel��������ϢLabel
	 */
	private static void setTextLocation(Node target, Label errorLabel) {
		Pane nodeContainer = (Pane) target.getParent();
		nodeContainer.getChildren().add(errorLabel);

		final double Y_OFFSET = 30.0;
		errorLabel.setLayoutX(target.getLayoutX());
		errorLabel.setLayoutY(target.getLayoutY() + Y_OFFSET);

	}
}