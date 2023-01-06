package com.example.assessment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.modalsheet_fragment.*

class ModalFragment: BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        //Return the inflate value of an xml modal fragment from the resource that is turned into a container
        return inflater.inflate(R.layout.modalsheet_fragment, container, false)
    }

}