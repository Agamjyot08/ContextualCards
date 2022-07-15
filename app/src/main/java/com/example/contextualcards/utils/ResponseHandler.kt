package com.example.contextualcards.utils


import android.content.Context
import androidx.fragment.app.Fragment
import com.example.contextualcards.data.Resource


fun Fragment.handleApiError(context: Context, failure: Resource.Failure, retry: (() -> Unit)? = null) {
    when {
        failure.isNetworkError -> requireView().snackbar(context,1,"Oops something went wrong..!", retry)

        failure.errorCode == -1 -> {// SocketTimeOut
            requireView().snackbar(context,1, "Timeout..!", retry)
        }

        failure.errorCode == 400 -> {//BadRequest
            requireView().snackbar(context,1, "BadRequest..!", retry)
        }

        failure.errorCode == 404 -> {//NotFound
            requireView().snackbar(context,1, "404 Not Found..!", retry)
        }

        failure.errorCode == 409 -> {//conflict
            requireView().snackbar(context,1,"Conflict..!", retry)
        }

        failure.errorCode == 500 -> {//InternalServerError
            requireView().snackbar(context,1,"Internal Server Error..!", retry)
        }

        failure.errorCode == 403 -> {//Forbidden
            requireView().snackbar(context,1,"Forbidden..!", retry)
        }

        failure.errorCode == 406 -> {//NotAcceptable
            requireView().snackbar(context, 1,"Not Acceptable..!", retry)
        }

        failure.errorCode == 503 -> {//ServiceUnavailable
            requireView().snackbar(context,1,"ServiceUnavailable..!", retry)
        }

        failure.errorCode == 401 -> {//UnAuthorized
            requireView().snackbar(context,1,"UnAuthorized..!", retry)
        }

        else -> {
            val error = failure.errorBody?.string().toString()
            requireView().snackbar(context, 1, error)
        }
    }
}

