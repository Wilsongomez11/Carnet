package com.example.carnet

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

data class Pet(val name: String, val breed: String, val size: String, val age: String, val photoUrl: String)

class PetViewModel : ViewModel() {
    var name by mutableStateOf("")
    var breed by mutableStateOf("")
    var size by mutableStateOf("")
    var age by mutableStateOf("")
    var photoUrl by mutableStateOf("")
    var petsList = mutableStateOf<List<Pet>>(emptyList())
    fun addPet() {
        val newPet = Pet(name, breed, size, age, photoUrl)
        petsList.value = petsList.value + newPet
    }

    fun removePet(pet: Pet) {
        petsList.value = petsList.value.filterNot { it == pet }
    }
}