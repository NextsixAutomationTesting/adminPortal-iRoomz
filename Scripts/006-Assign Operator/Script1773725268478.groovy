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

WebUI.callTestCase(findTestCase('000-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Unit/span_Property'))

WebUI.click(findTestObject('Active Tenant/span_Room'))

unit = WebUI.getText(findTestObject('Active Tenant/span_SWX0490'))

WebUI.click(findTestObject('Operator/span_Operator'))

WebUI.click(findTestObject('Operator/span_Operator Data'))

operator = WebUI.getText(findTestObject('Operator/span_mo b'))

WebUI.click(findTestObject('Active Operator/span_Active Operator'))

WebUI.click(findTestObject('Active Operator/button_Assign Operator'))

WebUI.setText(findTestObject('Active Operator/div_Type to search unit_css-b2ai5y'), unit)

WebUI.click(findTestObject('Active Operator/p_QVX3552'))

WebUI.click(findTestObject('Active Operator/button_Next Step'))

WebUI.setText(findTestObject('Active Operator/div_concat(Type operator, , s full name mob_c7f8f9'), operator)

WebUI.click(findTestObject('Active Operator/p_mo b  0122223333  mob.iroomzyopmail.com'))

WebUI.click(findTestObject('Active Operator/button_Next Step_1'))

WebUI.click(findTestObject('Active Operator/span_Submit'))

WebUI.verifyElementText(findTestObject('Active Operator/span_mo b'), operator)

WebUI.verifyElementText(findTestObject('Active Operator/span_QVX3552'), unit)

WebUI.closeBrowser()

