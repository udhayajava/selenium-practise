package VelSir;

public interface Operation {
    void openBrowser();
    void getAllLinks() throws InterruptedException;
    void confirmDialogBox();
    void cancelDialogBox();
    void getLinkCount();
    void getListItem();
    void isChecked();
    void closeBrowser();

}
