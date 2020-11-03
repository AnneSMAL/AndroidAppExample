package be.henallux.ig3.android.app.example.ui.module6

import be.henallux.ig3.android.app.example.R
import be.henallux.ig3.android.app.example.ui.ModulePresentationFragment

/**
 * As you can see, even if @ModulePresentationFragment is a Java class, we can override it with in a Kotlin
 * class. Kotlin does not have any problem to work hand-in-hand with Java in a same project.
 * This is one of the main strength of the language.
 */
class KotlinPresentationFragment : ModulePresentationFragment() {

    /**
     * Kotlin also provide what we call a Simplified declared function : If your function contains
     * only one instruction, you can bypass the accolades and the return statement to make your code
     * more concise.
     */
    override fun getDescriptionResources(): Int = R.string.module_6_description

    override fun getTitleResources(): Int = R.string.module_6_title

    override fun getNextScreenNavigationAction(): Int = R.id.action_mod6PresentationFragment_to_whatIsKotlinFragment
}