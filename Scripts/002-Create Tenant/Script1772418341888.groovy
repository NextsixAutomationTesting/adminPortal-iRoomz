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

WebUI.click(findTestObject('Tenant/span_Tenant'))

WebUI.click(findTestObject('Tenant/span_Tenant Data'))

WebUI.click(findTestObject('Tenant/button_Create'))

tenantInfo = WS.sendRequest(findTestObject('Tenant/Tenant Info'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(tenantInfo.getResponseBodyContent())

fullname = result.address.Full_Name

email = (result.address.Username + '@yopmail.com')

contact = ('01' + RandomStringUtils.randomNumeric(8))

icnum = ((((('9' + RandomStringUtils.randomNumeric(5)) + '-') + RandomStringUtils.randomNumeric(2)) + '-') + RandomStringUtils.randomNumeric(
    4))

line1 = result.address.Address

city = result.address.City

postcode = result.address.Zip_Code

WebUI.setText(findTestObject('Tenant/input_Full Name_name'), fullname)

WebUI.setText(findTestObject('Tenant/input_Nickname_nickname'), fullname)

WebUI.setText(findTestObject('Tenant/input_Email Address_email_1'), email)

WebUI.setText(findTestObject('Tenant/input_Mobile Contact_mobile'), contact)

WebUI.setText(findTestObject('Tenant/input_NRIC_number'), icnum)

WebUI.setText(findTestObject('Tenant/input_Line 1_line1'), line1)

WebUI.setText(findTestObject('Tenant/input_City_city'), city)

WebUI.setText(findTestObject('Tenant/input_Area_area'), city)

WebUI.setText(findTestObject('Tenant/input_Postcode_postcode'), postcode)

WebUI.click(findTestObject('Tenant/div_State_css-liki3c'))

WebUI.delay(1)

WebUI.click(findTestObject('Tenant/div_Johor'))

WebUI.setText(findTestObject('Tenant/input_Country_country'), 'Malaysia')

tenantEmer = WS.sendRequest(findTestObject('Tenant/Tenant Info'))

def slurper2 = new groovy.json.JsonSlurper()

def result2 = slurper2.parseText(tenantEmer.getResponseBodyContent())

emername = result2.address.Full_Name

WebUI.setText(findTestObject('Tenant/input_Name_emergName'), emername)

contact2 = ('01' + RandomStringUtils.randomNumeric(8))

WebUI.setText(findTestObject('Tenant/input_Contact No_emergPhone'), contact2)

WebUI.setText(findTestObject('Tenant/input_Relationship with tenant_relationship'), 'Parent')

emertitle = (new Random().nextInt(3) + 1)

WebUI.selectOptionByIndex(findTestObject('Tenant/select_Select oneMrMrsMs'), emertitle)

WebUI.click(findTestObject('Tenant/span_Submit'))

WebUI.click(findTestObject('Tenant/button_Cancel'))

WebUI.verifyElementText(findTestObject('Tenant/span_NicknameCreated'), fullname)

WebUI.closeBrowser()

