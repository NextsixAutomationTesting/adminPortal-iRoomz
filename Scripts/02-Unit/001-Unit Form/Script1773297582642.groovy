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

/*CREATE NEW UNIT*/
WebUI.callTestCase(findTestCase('01-Login/000-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Unit/span_Property'))

WebUI.click(findTestObject('Unit/span_Unit'))

WebUI.click(findTestObject('Unit/button_Create'))

au = RandomStringUtils.randomAlphabetic(3)

unitName = (au.toString().toUpperCase() + RandomStringUtils.randomNumeric(4))

WebUI.setText(findTestObject('Unit/input_Unit Name_propertyUnitName'), unitName)

manage = (new Random().nextInt(2) + 1)

//println(manage)
if (manage == 2) {
    WebUI.click(findTestObject('Unit/input_Managed By_managedByManagement'))

    management = (new Random().nextInt(5) + 1)

    //println(management)
    switch (management) {
        case 1:
            WebUI.click(findTestObject('Unit/input_Management Fee  (Total Collection Of _787321'))

            break
        case 2:
            WebUI.click(findTestObject('Unit/input_Management Fee  (Total Collection Of _adefa9'))

            break
        case 3:
            WebUI.click(findTestObject('Unit/input_Management Fee  Fixed Amount That Ins_aa57b6'))

            break
        case 4:
            WebUI.click(findTestObject('Unit/input_Management Fee  Total Collection Of R_e45128'))

            break
        case 5:
            WebUI.click(findTestObject('Unit/input_Management Fee Format of Management P_1ebfaa'))

            break
    }
    
    WebUI.setText(findTestObject('Unit/input_Management Fee_managementFee'), '10')

    WebUI.setText(findTestObject('Unit/input_RM_subscriptionFee'), '50')
}

unitInfo = WS.sendRequest(findTestObject('Tenant/Tenant Info'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(unitInfo.getResponseBodyContent())

address = result.address.Address

city = result.address.City

postcode = result.address.Zip_Code

WebUI.setText(findTestObject('Unit/input_Line 1_line1'), address)

WebUI.setText(findTestObject('Unit/input_Postcode_postcode'), postcode)

WebUI.setText(findTestObject('Unit/input_City_city'), city)

WebUI.setText(findTestObject('Unit/input_Area_area'), city)

WebUI.setText(findTestObject('Unit/input_State_state'), 'KL')

room1 = (unitName + '_Room 1')

WebUI.setText(findTestObject('Unit/input_Room Name_roomData.0.name'), room1)

rental = (('1' + RandomStringUtils.randomNumeric(2)) + '0')

WebUI.setText(findTestObject('Unit/input_RM_roomData.0.rental'), rental)

WebUI.setText(findTestObject('Unit/input_Room Type_roomData.0.roomType'), 'Master Bedroom')

WebUI.setText(findTestObject('Unit/input_RM_roomData.0.rentalDeposit'), rental)

WebUI.setText(findTestObject('Unit/input_RM_roomData.0.utilityDeposit'), '0')

WebUI.setText(findTestObject('Unit/input_RM_roomData.0.ratePerUnit'), '0.65')

WebUI.click(findTestObject('Unit/input_Postpaid_Prepaid'))

WebUI.click(findTestObject('Unit/button_Add Room'))

room2 = (unitName + '_Room 2')

WebUI.setText(findTestObject('Unit/input_Room Name_roomData.1.name'), room2)

rental1 = (new Random().nextInt(4) + 6)

rental2 = ((rental1 + RandomStringUtils.randomNumeric(1)) + '0')

WebUI.setText(findTestObject('Unit/input_RM_roomData.1.rental'), rental2)

WebUI.setText(findTestObject('Unit/input_Room Type_roomData.1.roomType'), 'Small Bedroom')

WebUI.setText(findTestObject('Unit/input_RM_roomData.1.rentalDeposit'), rental2)

WebUI.setText(findTestObject('Unit/input_RM_roomData.1.utilityDeposit'), '0')

WebUI.setText(findTestObject('Unit/input_RM_roomData.1.ratePerUnit'), '0.65')

WebUI.click(findTestObject('Unit/input_Postpaid_Prepaid_1'))

WebUI.scrollToElement(findTestObject('Unit/span_Submit'), 10)

WebUI.click(findTestObject('Unit/span_Submit'))

WebUI.waitForElementVisible(findTestObject('Unit/span_ABA2200'), 10)

created = (((room1 + ' - ') + rental) + '.00')

WebUI.verifyElementText(findTestObject('Unit/p_CZH0191_Room 1 - 2200.00'), created)

/*EDIT UNIT*/
unitEdit = (unitName + '_EDITED')

WebUI.click(findTestObject('Unit/button_'))

WebUI.click(findTestObject('Unit/a_Edit Unit Info'))

WebUI.setText(findTestObject('Unit/input_Unit Name_propertyUnitName'), unitEdit)

WebUI.scrollToElement(findTestObject('Unit/span_Update'), 10)

WebUI.click(findTestObject('Unit/span_Update'))

if (manage == 2) {
    editVerify = (('M' + '\n') + unitEdit)
} else {
    editVerify = unitEdit
}

WebUI.verifyElementText(findTestObject('Unit/span_MJAT8624_EDITED'), editVerify)

/*UPLOAD ATTACHMENT*/
WebUI.click(findTestObject('Unit/button_'))

WebUI.click(findTestObject('Unit/a_Edit Attachment'))

file1 = 'C:\\file1.png'

WebUI.uploadFile(findTestObject('Unit/div_Upload New Attachment_at-input-upload'), file1)

WebUI.click(findTestObject('Unit/span_Submit'))

WebUI.waitForElementPresent(findTestObject('Unit/div_New attachment uploaded successfully'), 10)

WebUI.click(findTestObject('Unit/button_'))

WebUI.click(findTestObject('Unit/a_Edit Attachment'))

WebUI.verifyElementPresent(findTestObject('Unit/img'), 10)

