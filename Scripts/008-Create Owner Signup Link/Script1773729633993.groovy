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
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.DataFlavor as DataFlavor

WebUI.callTestCase(findTestCase('01-Login/000-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Owner/span_Owner'))

WebUI.click(findTestObject('Owner/span_Owner Data'))

WebUI.click(findTestObject('Owner/button_Create Sign Up Link'))

WebUI.click(findTestObject('Owner Signup/button_Copy'))

Toolkit toolkit = Toolkit.getDefaultToolkit()

Clipboard clipboard = toolkit.getSystemClipboard()

String signupurl = ((clipboard.getData(DataFlavor.stringFlavor)) as String)

WebUI.newTab(signupurl)

ownerInfo = WS.sendRequest(findTestObject('Tenant/Tenant Info'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(ownerInfo.getResponseBodyContent())

fullname = result.address.Full_Name

email = (result.address.Username + '@yopmail.com')

contact = ('01' + RandomStringUtils.randomNumeric(8))

icnum = ((((('9' + RandomStringUtils.randomNumeric(5)) + '-') + RandomStringUtils.randomNumeric(2)) + '-') + RandomStringUtils.randomNumeric(
    4))

line1 = result.address.Address

city = result.address.City

postcode = result.address.Zip_Code

WebUI.setText(findTestObject('Owner Signup/input_Full Name_name'), fullname)

WebUI.click(findTestObject('Owner Signup/input_Male_gender'))

WebUI.setText(findTestObject('Owner Signup/input_Email Address_email'), email)

WebUI.setText(findTestObject('Owner Signup/input_Mobile Contact_mobile'), contact)

WebUI.setText(findTestObject('Owner Signup/input_NRICPassport_number'), icnum)

WebUI.setText(findTestObject('Owner Signup/input_Line 1_line1'), line1)

WebUI.setText(findTestObject('Owner Signup/input_City_city'), city)

WebUI.setText(findTestObject('Owner Signup/input_Area_area'), city)

WebUI.setText(findTestObject('Owner Signup/input_Postcode_postcode'), postcode)

WebUI.click(findTestObject('Owner Signup/div_State_css-liki3c'))

WebUI.click(findTestObject('Owner Signup/div_Johor'))

WebUI.setText(findTestObject('Owner Signup/input_Country_country'), 'Malaysia')

WebUI.scrollToElement(findTestObject('Owner Signup/span_Submit'), 10)

WebUI.click(findTestObject('Owner Signup/span_Submit'))

WebUI.switchToWindowUrl('https://sit-admin.iroomz.com/owner/data')

WebUI.refresh()

WebUI.verifyElementText(findTestObject('Owner/span_Yi re NI SHI'), fullname)

WebUI.closeBrowser()

