import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('01-Login/000-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Billing Report/span_Accounting'))

WebUI.click(findTestObject('Billing Report/span_Billings'))

WebUI.check(findTestObject('Billing Report/input_Refund_type'))

WebUI.click(findTestObject('Billing Report/button_search'))

bill = WebUI.getText(findTestObject('Billing Report/span_BIL0014909'))

billid = ('Bill ID: ' + bill)

unit = WebUI.getText(findTestObject('Billing Report/span_NYY6870'))

amount = WebUI.getText(findTestObject('Billing Report/span_1260.00'))

report = ((amount + '\n') + 'Show More')

WebUI.doubleClick(findTestObject('Billing Report/div_Issued - Payment Failed'))

WebUI.click(findTestObject('Billing Report/div_Issued - Payment Failed'))

WebUI.click(findTestObject('Billing Report/div_Paid'))

WebUI.click(findTestObject('Billing Report/div_Select payment method_select__input-con_503d88'))

WebUI.click(findTestObject('Billing Report/div_Cash'), FailureHandling.STOP_ON_FAILURE)

file1 = 'C:\\file1.png'

WebUI.uploadFile(findTestObject('Billing Report/div_Upload New Attachment_at-input-upload'), file1)

WebUI.click(findTestObject('Billing Report/span_Confirm'))

WebUI.click(findTestObject('Billing Report/span_Receipts'))

WebUI.verifyElementText(findTestObject('Billing Report/span_Bill ID BIL0014667'), billid)

WebUI.click(findTestObject('Billing Report/span_Accounting'))

WebUI.click(findTestObject('Billing Report/span_Report'))

WebUI.click(findTestObject('Billing Report/span_Management Property Payout Report'))

WebUI.setText(findTestObject('Billing Report/input_Logout_form-control td-filter-input'), unit)

WebUI.click(findTestObject('Billing Report/button_search'))

if (WebUI.verifyElementText(findTestObject('Object Repository/Billing Report/span_0 records'), '0 records')) 
	{
    WebUI.selectOptionByIndex(findTestObject('Billing Report/select_Management UnitNon-Management Unit'), 1)

    WebUI.click(findTestObject('Billing Report/button_search'))
}

WebUI.verifyElementText(findTestObject('Billing Report/td_1260.00Show More'), report)

