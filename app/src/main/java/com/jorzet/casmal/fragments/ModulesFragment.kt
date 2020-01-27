/*
 * Copyright [2020] [Jorge Zepeda Tinoco]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jorzet.casmal.fragments

import android.util.Log
import android.widget.ListView
import com.jorzet.casmal.R
import com.jorzet.casmal.adapters.ExamsAdapter
import com.jorzet.casmal.base.BaseFragment
import com.jorzet.casmal.managers.FirebaseRequestManager
import com.jorzet.casmal.models.Exam

/**
 * @author Jorge Zepeda Tinoco
 * @email jorzet.94@gmail.com
 * @date 12/08/19.
 */

class ModulesFragment: BaseFragment() {

    /**
     * UI accessors
     */
    private lateinit var mModulesListView: ListView

    /**
     * Adapter
     */
    private lateinit var mExamsAdapter: ExamsAdapter

    override fun getLayoutId(): Int {
        return R.layout.modules_fragment
    }

    override fun initView() {
        mModulesListView = rootView.findViewById(R.id.lv_modules)
    }

    override fun prepareComponents() {
        FirebaseRequestManager.getInstance().requestExams(object: FirebaseRequestManager.OnGetExamsListener {
            override fun onGetExamsSuccess(exams: List<Exam>) {
                Log.d("","")

                mExamsAdapter = ExamsAdapter(exams)
                mExamsAdapter.mExamClickListener = object: ExamsAdapter.OnExamClickListener {
                    override fun onExamClick(exam: Exam) {
                        goQuestionActivity(exam.questions, true, exam.examId)
                    }
                }

                mModulesListView.adapter = mExamsAdapter
            }

            override fun onGetExamsFail(throwable: Throwable) {
                Log.d("","")
            }
        })
    }
}