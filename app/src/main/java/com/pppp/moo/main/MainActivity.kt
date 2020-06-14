package com.pppp.moo.main

import android.os.Bundle
import android.view.ViewGroup
import com.badoo.mvicore.android.AndroidTimeCapsule
import com.badoo.ribs.android.RibActivity
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.builder.BuildContext
import com.pppp.moo.R
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher
import com.pppp.moo.main.tabbed_switcher.builder.TabbedSwitcherBuilder

class MainActivity : RibActivity() {

    override val rootViewGroup: ViewGroup
        get() = findViewById(R.id.root)

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.main_activity)
        super.onCreate(savedInstanceState)

    }

    override fun createRib(savedInstanceState: Bundle?): Rib =
        TabbedSwitcherBuilder(object : TabbedSwitcher.Dependency {})
            .build(BuildContext.root(savedInstanceState), TabbedSwitcherBuilder.Params("Foo"))

}
