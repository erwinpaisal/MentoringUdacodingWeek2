package id.erwinpaisal.calculatorbmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SelectViewModel : ViewModel() {

    private var etBerat = MutableLiveData<Int>()
    val beratEt: LiveData<Int>
        get() = etBerat

    private var etUsia = MutableLiveData<Int>()
    val usiaEt: LiveData<Int>
        get() = etUsia


    init {
        etBerat.value = 40
        etUsia.value = 18
    }

    fun tambah_berat() {
        etBerat.value = etBerat.value?.plus(1)

    }

    fun hapus_berat() {
        etBerat.value = etBerat.value?.minus(1)
    }

    fun tambah_usia() {
        etUsia.value = etUsia.value?.plus(1)
    }

    fun hapus_usia() {
        etUsia.value = etUsia.value?.minus(1)
    }
}