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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

WebUI.callTestCase(findTestCase('01-Login/000-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Operator/span_Operator'))

WebUI.click(findTestObject('Operator/span_Operator Data'))

WebUI.click(findTestObject('Operator/button_Create'))

operatorInfo = WS.sendRequest(findTestObject('Tenant/Tenant Info'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(operatorInfo.getResponseBodyContent())

fullname = result.address.Full_Name

email = (result.address.Username + '@yopmail.com')

contact = ('01' + RandomStringUtils.randomNumeric(8))

icnum = ((((('9' + RandomStringUtils.randomNumeric(5)) + '-') + RandomStringUtils.randomNumeric(2)) + '-') + RandomStringUtils.randomNumeric(
    4))

line1 = result.address.Address

city = result.address.City

postcode = result.address.Zip_Code

WebUI.setText(findTestObject('Operator/input_Full Name_name'), fullname)

WebUI.setText(findTestObject('Operator/input_Email Address_email'), email)

WebUI.setText(findTestObject('Operator/input_Mobile Contact_mobile'), contact)

WebUI.setText(findTestObject('Operator/input_NRIC_number'), icnum)

WebUI.setText(findTestObject('Operator/input_Line 1_line1'), line1)

WebUI.setText(findTestObject('Operator/input_Area_area'), city)

WebUI.setText(findTestObject('Operator/input_City_city'), city)

WebUI.setText(findTestObject('Operator/input_State_state'), 'KL')

WebUI.setText(findTestObject('Operator/input_Postcode_postcode'), postcode)

WebUI.setText(findTestObject('Operator/input_Country_country'), 'Malaysia')

WebUI.click(findTestObject('Operator/button_Submit'))

WebUI.waitForElementVisible(findTestObject('Operator/span_mo b'), 10)

WebUI.verifyElementText(findTestObject('Operator/span_mo b'), fullname)

WebUI.closeBrowser()

