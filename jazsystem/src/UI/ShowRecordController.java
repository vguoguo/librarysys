package UI;

import java.util.List;

import Application.Book;
import Application.CheckOutEntry;
import Application.Item;
import Application.Member;
import Application.Periodical;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ShowRecordController {
	@FXML
	private TextField memberField;
	@FXML
	private TextField titleField;
	@FXML
	private TextField maxDaysField;
	
	@FXML
	private AnchorPane topAnchorPane;
	
	@FXML
	private TableView<COETableModel> entryTableView;
	
	
	
	private Stage showRecordStage;
	private Member member;
	private Item item;
	private SystemController systemController = new SystemController();
	private ObservableList<COETableModel> obvList = FXCollections.observableArrayList();
	
	
	
	public void setShowRecordStage(Stage showRecordStage) {
		this.showRecordStage = showRecordStage;
	}
	
	public void initEntryTableView(){
		entryTableView.setItems(obvList);
	}

	@FXML
	public void handleConfirmCheckoutButton(ActionEvent event) {
		Book book = null;
		Periodical periodical = null;
		if (item instanceof Book){
			book = (Book) item;
			systemController.CheckOutBook(member, book);
		}
		else{
			periodical = (Periodical) item;
			systemController.Checkout(member, periodical);
		}
		topAnchorPane.setVisible(false);
		updateTableView();
	}
	
	@FXML
	public void handleCloseButton(ActionEvent event) {
		clearMemberItem();
		obvList.clear();
		showRecordStage.close();
	}
	
	@FXML
	public void handlePaperButton(ActionEvent event) {
		systemController.printMemberCheckout(this.member.getMemberID());
	}
	
	public void setMemberItem(Member member, Item item){
		this.member = member;
		this.item = item;
		
		if (item == null){
			topAnchorPane.setVisible(false);
		}
		else{
			topAnchorPane.setVisible(true);
			memberField.setText(member.getFirstname() + " " + member.getLastname());
			titleField.setText(item.getTitle());
			maxDaysField.setText(Integer.toString(item.getMax_day_borrow()));
		}
		updateTableView();
	}
	
	private void updateTableView(){
		obvList.clear();
		String itemId, title, showId;
		Item book = null;
		Item periodical = null;
		
		List<CheckOutEntry> coeList = member.getCheckoutrecord().getCheckoutentries();
		for (CheckOutEntry coe : coeList){
			itemId = coe.getCopy().getItemID();
			showId = itemId.substring(1);
			if ("B".compareTo(itemId.substring(0, 1)) == 0) {
				book = systemController.searchBook(itemId);
				title = book.getTitle();
			}
			else{
				periodical = systemController.searchPeriodical(itemId);
				title = periodical.getTitle();
			}
			
			obvList.add(new COETableModel(coe.getM_CheckoutDate().toString(), coe.getM_DueDate().toString(),
					showId, title, Integer.toString(coe.getCopy().getCopiID()), ""));
		}
	}
	
	private void clearMemberItem(){
		memberField.clear();
		titleField.clear();
		maxDaysField.clear();
	}
}
