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

/*FORGOT PASSWORD*/
WebUI.openBrowser('https://sit-admin.iroomz.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Login/button_forgot password'))

WebUI.setText(findTestObject('Login/input_Email Address_email (1)'), 'alee.iroomz@yopmail.com')

WebUI.click(findTestObject('Login/span_Submit'))

WebUI.navigateToUrl('https://yopmail.com/en/')

WebUI.setText(findTestObject('Login/input_Type the Email name of your choice_login'), 'alee.iroomz@yopmail.com')

WebUI.click(findTestObject('Login/i_'))

pwurl = WebUI.getText(findTestObject('Login/span_sit-admin.iroomz.comreset-password28c7_68ce87'))

WebUI.navigateToUrl(pwurl)

pass = ((RandomStringUtils.randomAlphabetic(4) + RandomStringUtils.randomNumeric(4)) + '!@')

WebUI.setText(findTestObject('Login/input_New Password_password'), pass)

WebUI.setText(findTestObject('Login/input_Confirm New Password_confirmPassword'), pass)

WebUI.click(findTestObject('Login/span_Confirm'))

WebUI.waitForElementPresent(findTestObject('Login/div_Password reset successfully. Click here_ffff70'), 0)

WebUI.click(findTestObject('Login/a_here'))

WebUI.setText(findTestObject('Login/input_Email Address_email'), 'alee.iroomz@yopmail.com')

WebUI.setText(findTestObject('Login/input_Password_password'), pass)

WebUI.click(findTestObject('Login/button_Sign In'))

WebUI.verifyElementPresent(findTestObject('Login/p_Dashboard'), 10)

/*CHANGE PASSWORD*/
WebUI.click(findTestObject('Login/button_Hi, Cado Admin'))

WebUI.click(findTestObject('Login/div_My Profile'))

WebUI.click(findTestObject('Login/div_Change Password'))

pass1 = ((RandomStringUtils.randomNumeric(4) + RandomStringUtils.randomAlphabetic(4)) + '!@')

WebUI.setText(findTestObject('Login/input_Old Password_oldPassword'), pass)

WebUI.setText(findTestObject('Login/input_New Password_newPassword'), pass1)

WebUI.setText(findTestObject('Login/input_Repeat New Password_repeatNewPassword'), pass1)

WebUI.click(findTestObject('Login/button_Save'))

WebUI.waitForElementPresent(findTestObject('Login/div_Your password has been changed successfully'), 0)

WebUI.click(findTestObject('Login/span_Dashboard'))

WebUI.click(findTestObject('Login/button_Hi, Cado Admin'))

WebUI.click(findTestObject('Login/button_Sign Out'))

WebUI.setText(findTestObject('Login/input_Email Address_email'), 'alee.iroomz@yopmail.com')

WebUI.setText(findTestObject('Login/input_Password_password'), pass1)

WebUI.click(findTestObject('Login/button_Sign In'))

WebUI.verifyElementPresent(findTestObject('Login/p_Dashboard'), 10)

WebUI.closeBrowser()

