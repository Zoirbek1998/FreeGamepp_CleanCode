package uz.telecom.freegamepp.domain.usecase

import uz.telecom.freegamepp.domain.repository.FreeGameRepository
import javax.inject.Inject

class FreeGameUseCase @Inject constructor(private  val repository: FreeGameRepository) {
    operator fun invoke() = repository.getFreeGames()
}