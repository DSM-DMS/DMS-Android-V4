package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.*
import com.dsm.dms.domain.entity.enums.ClassNum
import com.dsm.dms.domain.entity.enums.GoingOutType
import com.dsm.dms.domain.entity.enums.StayInfo
import com.dsm.dms.domain.repository.ExtensionRepository
import com.dsm.dms.domain.repository.GoingOutRepository
import com.dsm.dms.domain.repository.UserRepository
import com.dsm.dms.domain.usecase.GetUserUseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class UserServiceTest: BaseTest() {

    @Mock
    private lateinit var userRepository: UserRepository
    @Mock
    private lateinit var goingOutRepository: GoingOutRepository
    @Mock
    private lateinit var extensionRepository: ExtensionRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var userService: UserService

    private lateinit var getUserUseCase: GetUserUseCase

    @Before
    fun init() {

        userService =
            UserServiceImpl(userRepository, goingOutRepository, extensionRepository, errorHandler)

        getUserUseCase = GetUserUseCase(userService, CompositeDisposable())

    }

    @Test
    fun `유저 정보 조회 성공`() {

        val user = User(
            name = "송진우",
            studentNumber = 3212,
            point = PointInfo(
                goodPoint = 100,
                badPoint = 0,
                penaltyLevel = 0
            ),
            apply = ApplyInfo(
                extension = listOf(
                    ExtensionInfo(
                        time = 12,
                        classNum = ClassNum.GAONSIL,
                        seatNum = 14
                    )
                ),
                stay = StayInfo.STAY,
                goingOut = listOf(
                    GoingOutInfo(
                        id = 1,
                        type = GoingOutType.MEAL_GOING,
                        date = "2020-08-31",
                        place = "서울"
                    )
                )
            )
        )
        val uuid = "12345678–1234–1234–1234–1234567890ab"

        `when`(userRepository.getRemoteUserData(uuid))
            .thenReturn(
                Single.just(user)
            )

        `when`(extensionRepository.getLocalAllExtensionInfo())
            .thenReturn(
                listOf(
                    ExtensionInfo(
                        time = 12,
                        classNum = ClassNum.GAONSIL,
                        seatNum = 14
                    )
                )
            )

        `when`(goingOutRepository.getLocalGoingOutInfo())
            .thenReturn(
                listOf(
                    GoingOutInfo(
                        id = 1,
                        type = GoingOutType.MEAL_GOING,
                        date = "2020-08-31",
                        place = "서울"
                    )
                )
            )

        `when`(userRepository.getLocalUserData())
            .thenReturn(user)

        getUserUseCase.create(uuid)
            .test().assertValue(
                Result.Success(user)
            )

    }

    @Test
    fun `유저 정보 조회 실패`() {

        val exception = Exception()
        val user = User(
            name = "송진우",
            studentNumber = 3212,
            point = PointInfo(
                goodPoint = 100,
                badPoint = 0,
                penaltyLevel = 0
            ),
            apply = ApplyInfo(
                extension = listOf(
                    ExtensionInfo(
                        time = 12,
                        classNum = ClassNum.GAONSIL,
                        seatNum = 14
                    )
                ),
                stay = StayInfo.STAY,
                goingOut = listOf(
                    GoingOutInfo(
                        id = 1,
                        type = GoingOutType.MEAL_GOING,
                        date = "2020-08-31",
                        place = "서울"
                    )
                )
            )
        )
        val uuid = "12345678–1234–1234–1234–1234567890ab"

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(userRepository.getRemoteUserData(uuid))
            .thenReturn(
                Single.error(exception)
            )

        `when`(extensionRepository.getLocalAllExtensionInfo())
            .thenReturn(
                listOf(
                    ExtensionInfo(
                        time = 12,
                        classNum = ClassNum.GAONSIL,
                        seatNum = 14
                    )
                )
            )

        `when`(goingOutRepository.getLocalGoingOutInfo())
            .thenReturn(
                listOf(
                    GoingOutInfo(
                        id = 1,
                        type = GoingOutType.MEAL_GOING,
                        date = "2020-08-31",
                        place = "서울"
                    )
                )
            )

        `when`(userRepository.getLocalUserData())
            .thenReturn(user)

        getUserUseCase.create(uuid)
            .test().assertValue(
                Result.Error(user, Message.UNKNOW_ERROR)
            )

    }
    
}
