package com.jorzet.casmal.room.tasks

import android.os.AsyncTask
import com.jorzet.casmal.interfaces.RoomOperationListener
import com.jorzet.casmal.models.Account
import com.jorzet.casmal.room.dao.AccountDao

class DeleteAccount(
    private val accountDao: AccountDao,
    private val account: Account,
    private val listener: RoomOperationListener
): AsyncTask<Void, Void, Account>() {
    override fun onPreExecute() {
        listener.onBegin()
    }

    override fun doInBackground(vararg params: Void?): Account {
        accountDao.delete(account)

        return account
    }

    override fun onPostExecute(account: Account?) {
        listener.onFinish()
    }
}