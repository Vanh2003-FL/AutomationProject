package Automation.Testsuite;

import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day12_Dropdownlist extends CommonBase {
//    Làm sao để chọn các giá trị: 1 khoá học của dropdown ở hình trên?
//            - Làm sao để kiểm tra trong dropdown có bao nhiêu giá trị => như hình trên có 5 giá trị?
//            - Làm sao để kiểm tra 1 giá trị trong dropdown hiển thị đúng hay chưa sau khi đã chọn thành công?
//            - Làm sao để kiểm tra dropdown có phải là multi-select hay single select => multi-select: cho phép chọn nhiều giá trị trong dropdown/ list?
   @Test
    public void handDropdown(){
        driver = initChromeBrowser("https://codestar.vn/khoa-hoc/");
        Select dropKhoaHoc = new Select(driver.findElement(By.id("product_categories_filter")));
        //chon gia tri aws
        dropKhoaHoc.selectByVisibleText("AWS");
        System.out.println("So luong option cua dropdown la: "+ dropKhoaHoc.getOptions().size());
        System.out.println("Gia tri sau khi chon la: "+  dropKhoaHoc.getFirstSelectedOption().getText());
        System.out.println("Multiple drowdown "+dropKhoaHoc.isMultiple());
    }
}
