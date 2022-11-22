package com.example.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Rule
import org.junit.Test

class ButtonWorkingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun previousButtonTest() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpace()
            }
        }

        composeTestRule.onNodeWithText("Previous").performClick().performClick()

        composeTestRule.
        onNodeWithText("Qutub Minar").assertExists()


    }

    @Test
    fun nextButtonTest() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpace()
            }
        }

        composeTestRule.onNodeWithText("Next").performClick().performClick()

        composeTestRule.onNodeWithText("Qutub Minar").assertExists()
    }


}