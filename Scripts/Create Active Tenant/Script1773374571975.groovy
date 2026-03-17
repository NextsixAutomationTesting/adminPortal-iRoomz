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
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Unit/span_Property'))

WebUI.click(findTestObject('Active Tenant/span_Room'))

String unit = WebUI.getText(findTestObject('Active Tenant/span_SWX0490'))

//println(unit)
WebUI.click(findTestObject('Active Tenant/span_Tenant'))

WebUI.click(findTestObject('Tenant/span_Tenant Data'))

String tenant = WebUI.getText(findTestObject('Active Tenant/span_KARAN PLUS'))

//println(tenant)
WebUI.click(findTestObject('Active Tenant/span_Active Tenant'))

WebUI.click(findTestObject('Active Tenant/button_New Booking'))

WebUI.setText(findTestObject('Active Tenant/search_room'), unit)

WebUI.click(findTestObject('Active Tenant/div_Desa 12 Mutiara Apartment  Desa Mutiara_b65c3f'))

WebUI.selectOptionByIndex(findTestObject('Active Tenant/select_Select one6 Months1 Year2 YearOther'), 1)

LocalDateTime nowTime = LocalDateTime.now().withDayOfMonth(1)

DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('dd/MM/yyyy')

String startDate = nowTime.format(dateFormat)

WebUI.setText(findTestObject('Active Tenant/input_Estimate Check In Date_form-control f_a51e08'), startDate)

WebUI.click(findTestObject('Active Tenant/button_Next Step'))

WebUI.setText(findTestObject('Active Tenant/div_concat(Type tenant, , s full name mobile contact email to search tenant)_css-liki3c'), 
    tenant)

WebUI.waitForElementVisible(findTestObject('Active Tenant/div_KELLY  0173510996  canyouseethat321yopmail.com'), 10)

WebUI.click(findTestObject('Active Tenant/div_KELLY  0173510996  canyouseethat321yopmail.com'))

WebUI.click(findTestObject('Active Tenant/button_Next Step_1'))

WebUI.click(findTestObject('Active Tenant/button_Submit'))

WebUI.click(findTestObject('Active Tenant/button_Next Step_2'))

WebUI.setText(findTestObject('Active Tenant/input_Number of Tenant_numberOfTenant'), '1')

WebUI.selectOptionByIndex(findTestObject('Active Tenant/select_Select oneMalayChineseIndianOther'), '1')

WebUI.selectOptionByIndex(findTestObject('Active Tenant/select_Select oneMrMrsMs'), '1')

rental = WebUI.getAttribute(findTestObject('Active Tenant/input_Advance Rental forMonth (RM)_advanceRental'), 'value')

//println(rental)

WebUI.setText(findTestObject('Active Tenant/input_Security DepositMonth (RM)_securityDeposit'), rental)

WebUI.setText(findTestObject('Active Tenant/input_Utility DepositMonth (RM)_utilityDeposit'), '0')

WebUI.setText(findTestObject('Active Tenant/input_Access Card Deposit (RM)_accessCardDeposit'), '0')

WebUI.click(findTestObject('Active Tenant/button_Next Step_3'))

WebUI.waitForElementVisible(findTestObject('Active Tenant/button_Submit_1'), 10)

WebUI.click(findTestObject('Active Tenant/button_Submit_1'))

WebUI.closeBrowser()

