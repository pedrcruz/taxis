package com.challenge.challenge.controller;

import com.challenge.challenge.InitJunitTests;
import com.challenge.challenge.controllers.TripController;
import com.challenge.challenge.dao.TripDTO;
import com.challenge.challenge.dao.ZoneDTO;
import com.challenge.challenge.enums.TripType;
import com.challenge.challenge.models.Zone;
import com.challenge.challenge.services.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TripControllerTest {

    private static final String REQUEST_URI = "http://localhost:8080/challenge";

    @Mock
    private TripService tripService;

    @InjectMocks
    private TripController tripController;

    private MockMvc mockMvc;
    private TripDTO tripDTO;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(tripController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
        tripDTO = TripDTO.builder()
                .pickupZone(Zone.builder().name("testPickUp").build())
                .dropoffZone(Zone.builder().name("testPickUp").build())
                .dropoffDatetime(LocalDateTime.now())
                .pickupDatetime(LocalDateTime.now())
                .build();
    }

    @Test
    void getYellowTrips_withValidDate_returnsYellowTripsDtoPage() throws Exception {
/*        Page<TripDTO> yellowTripsPage = new PageImpl<>(Collections.singletonList(tripDTO));
        when(tripService.getTrips(any(TripType.class), any(Pageable.class))).thenReturn(yellowTripsPage);
        mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_URI + "/list-yellow")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].pickupZone").value("testPickUp"));

*/
    }
}