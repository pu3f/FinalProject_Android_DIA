package com.example.projectdia.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectdia.adapter.JobAdapter
import com.example.projectdia.adapter.ListAdapter
import com.example.projectdia.databinding.FragmentHomeBinding
import com.example.projectdia.model.JobPosition
import com.example.projectdia.model.getalljob.Data
import com.example.projectdia.model.getalljob.JobResponse
import com.example.projectdia.repository.AppRepository
import com.example.projectdia.service.AppRetrofit
import com.example.projectdia.utils.SQLiteHelper
import com.example.projectdia.viewmodel.JobViewModel
import io.reactivex.Single
import io.reactivex.SingleObserver
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding:FragmentHomeBinding?= null
    private val binding get() = _binding!!

//    private var listJob: List<JobViewModel>?= null
//    private var adapter = JobAdapter = JobAdapter()

//    var layoutManager: RecyclerView.LayoutManager? = null
//    private lateinit var sqLiteHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvListJob.layoutManager = layoutManager
//        adapter.jobClickListener = this
//        binding.rvListJob.adapter = adapter

//        val services = AppRetrofit.create()
//        services.getAllJob().(object:Single<JobResponse>{
//            override fun subscribeActual(observer: SingleObserver<in JobResponse>) {
//                TODO("Not yet implemented")
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun setObserver() {
//        viewModel.listResponse().observe(viewLifecycleOwner, Observer {
//            binding.rvListJob.adapter
//            Log.d("listapp", "if22")
//            adapter.initData(it.data as ArrayList<Data>)
//        })
//    }
//        sqLiteHelper = SQLiteHelper(requireContext())
////        val listJob = listOf(
////            JobPosition("Chef", "https://img.freepik.com/free-vector/cute-chef-girl-smiling-uniform-welcoming-inviting-his-guests-cartoon-art-illustration_56104-578.jpg?w=900"),
////            JobPosition("Teacher", "https://www.nea.org/sites/default/files/styles/960wide/public/legacy/2020/04/new_teacher-1-e1588171214853.jpeg?itok=PnBTyZig")
////        )
//        layoutManager = LinearLayoutManager(context)
//        adapter = ListAdapter(sqLiteHelper.getAllJobs(), requireContext())
//        binding.rvList.adapter = adapter
//        binding.rvList.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = adapter
//        }
//
//        binding.btnAddData.setOnClickListener {
//            addJob()
//        }
//    }

//    private fun addJob(){
//        val jobName = binding.etJobName.text.toString()
//        val image = binding.etImage.text.toString()
//
//        val job = JobPosition(jobName = jobName, image = image)
//        val status = sqLiteHelper.insertJob(job)
//
//        if (status > -1){
//            Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
//            adapter?.arrayList = sqLiteHelper.getAllJobs()
//            adapter?.notifyDataSetChanged()
//
//        } else {
//            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
//        }
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}