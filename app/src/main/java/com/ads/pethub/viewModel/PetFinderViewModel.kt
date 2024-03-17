package com.ads.pethub.viewModel

import androidx.lifecycle.ViewModel
import com.ads.pethub.R
import com.ads.pethub.model.MissingPet

class PetFinderViewModel : ViewModel() {

    val missingPetsMock = listOf(
        MissingPet(
            petName = "Átila",
            image = R.drawable.dog_placeholder,
            date = "10/03/2024",
            time = "19h30",
            address = "Av. Cruzeiro do Sul",
            number = "1800",
            neighborhood = "Santana",
            city = "São Paulo",
            state = "SP",
        ),
        MissingPet(
            petName = "Barbie",
            image = R.drawable.cat2_placeholder,
            date = "14/03/2024",
            time = "14h30",
            address = "Av. Nova Independência",
            number = "850",
            neighborhood = "Brooklin Paulista",
            city = "São Paulo",
            state = "SP"
        ),
        MissingPet(
            petName = "Frodo",
            image = R.drawable.dog4_placeholder,
            date = "08/03/2024",
            time = "15h00",
            address = "Rua Brigadeiro Tobias de Aguiar",
            number = "200",
            neighborhood = "Jardim Independência",
            city = "Ribeirão Preto",
            state = "SP",
        ),
        MissingPet(
            petName = "Giraia",
            image = R.drawable.dog2_placeholder,
            date = "07/03/2024",
            time = "20h30",
            address = "Av. Caramuru",
            number = "1000",
            neighborhood = "Alto da Boa Vista",
            city = "Ribeirão Preto",
            state = "SP",
        ),
        MissingPet(
            petName = "Sakura",
            image = R.drawable.cat_placeholder,
            date = "15/03/2024",
            time = "12h30",
            address = "Av. Saudade",
            number = "850",
            neighborhood = "Campos Elísios",
            city = "Ribeirão Preto",
            state = "SP",
        ),
    )
}