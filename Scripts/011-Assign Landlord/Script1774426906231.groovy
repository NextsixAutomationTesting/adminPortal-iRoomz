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

WebUI.callTestCase(findTestCase('000-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Landlord/span_Landlord'))

WebUI.click(findTestObject('Landlord/span_Landlord Data'))

landlord = WebUI.getText(findTestObject('Landlord/span_Lala'))

WebUI.click(findTestObject('Unit/span_Property'))

WebUI.click(findTestObject('Unit/span_Unit'))

WebUI.click(findTestObject('Active Landlord/button_Link to Landlord'))

WebUI.click(findTestObject('Active Landlord/button_Next Step'))

WebUI.setText(findTestObject('Active Landlord/div_concat(Type landlord, , s full name mob_044505'), landlord)

WebUI.click(findTestObject('Active Landlord/p_Ali  017-3510992  imali0926yopmail.com'))

WebUI.click(findTestObject('Active Landlord/button_Next Step_1'))

LocalDateTime nowTime = LocalDateTime.now().withDayOfMonth(1)

DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern('dd/MM/yyyy')

String startDate = nowTime.format(dateFormat)

WebUI.setText(findTestObject('Active Landlord/input_Agreement Start Date_form-control for_e219ae'), startDate)

WebUI.setText(findTestObject('Active Landlord/input_RM_rental'), '1000')

WebUI.check(findTestObject('Active Landlord/input_Viewable to Landlord_landlordView'))

WebUI.click(findTestObject('Active Landlord/button_Next Step_2'))

WebUI.click(findTestObject('Active Landlord/span_Submit'))

WebUI.verifyElementText(findTestObject('Active Landlord/span_Ali'), landlord)

WebUI.closeBrowser()