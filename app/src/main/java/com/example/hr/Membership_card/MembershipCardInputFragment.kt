package com.example.hr.Membership_card


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.hr.R

/**
 * A simple [Fragment] subclass.
 */
class MembershipCardInputFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var obj_hr_membership_card : hr_membership_card

    var Str_key = "" // key obj_hr_work_experience from firebase

    data class hr_membership_card (
        var username: String? = "",
        var membership_name: String? = "",
        var membership_id: String? = "",
        var issue_date: String? = "",
        var expiry_date: String? = ""
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_membership_card_input, container, false)

        val view_membership_name = view.findViewById<TextView>(R.id.view_membership_name)
        val view_membership_id = view.findViewById<TextView>(R.id.view_membership_id)
        val view_issue_date= view.findViewById<TextView>(R.id.view_issue_date)
        val view_expiry_date = view.findViewById<TextView>(R.id.view_expiry_date)

        val btn_back = view.findViewById(R.id.view_btn_back) as ImageButton
        val btn_delete = view.findViewById(R.id.view_btn_delete) as ImageButton
        val btn_save = view.findViewById(R.id.view_btn_save) as Button
        if(Str_key != "") {
            view_membership_name.setText(obj_hr_membership_card.membership_name)
            view_membership_id.setText(obj_hr_membership_card.membership_id)
            view_issue_date.setText(obj_hr_membership_card.issue_date)
            view_expiry_date.setText(obj_hr_membership_card.expiry_date)
        }

        return view
    }


    fun newInstance(key: String, username:String, membership_name: String, membership_id:String, issue_date:String, expiry_date:String): MembershipCardInputFragment {
        val fragment = MembershipCardInputFragment()
        val bundle = Bundle()
        bundle.putString("key", key)
        bundle.putString("username", username)
        bundle.putString("membership_name", membership_name)
        bundle.putString("membership_id", membership_id)
        bundle.putString("issue_date", issue_date)
        bundle.putString("expiry_date", expiry_date)
        fragment.setArguments(bundle)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            obj_hr_membership_card = hr_membership_card(
                bundle.getString("username").toString(),
                bundle.getString("membership_name").toString(),
                bundle.getString("membership_id").toString(),
                bundle.getString("issue_date").toString(),
                bundle.getString("expiry_date").toString()
            )
            Str_key = bundle.getString("key").toString()
        }
    }


}
