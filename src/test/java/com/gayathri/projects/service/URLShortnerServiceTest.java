package com.gayathri.projects.service;


import com.gayathri.projects.dto.ShortnerRequestDTO;
import com.gayathri.projects.dto.ShortnerResponseDTO;
import com.gayathri.projects.model.URLShortner;
import com.gayathri.projects.repository.URLShortnerRepo;
import com.gayathri.projects.util.URLGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;


/* @ExtendWith(MockitoExtension.class) is a Junit5 way to integrate mock tests
* It activates Mockito for JUnit 5.
* IT creates mock objects, injects them and manage their life cycle
* Test classes do not need to be public because Junit can access package private class and no other packages or classes need to access test classes
* This is  Service Unit Test class
 */
@ExtendWith(MockitoExtension.class)
class URLShortnerServiceTest {

    /* using @Mock we are creating mock objects for util nd model classes
    * Using @InhectMocks we create real  objects of this class and inject mock into it automatically*/

    @Mock
    private URLShortnerRepo urlShortnerRepo;

    @Mock
    private URLGenerator urlGenerator;

    @InjectMocks
    private URLShortnerServiceImpl urlShortnerService;

    /* Our test method must always have @Test annotation to it */
    @Test
    void shouldGenerateShortUrl() {
        // GIVEN
        /* Test Data setup */
        ShortnerRequestDTO request =
                ShortnerRequestDTO.builder()
                        .originalurl("https://google.com")
                        .build();

        /*By the following lines we tell mockito When the service calls its dependencies, don’t execute real logic.
Instead, return exactly what I decide. */

        when(urlGenerator.shorten("https://google.com"))
                .thenReturn("abc123");
        when(urlShortnerRepo.existsByShorturl("abc123")).thenReturn(false);
        when(urlShortnerRepo.save(any(URLShortner.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // WHEN
        /* This line is where the actual behavior under test is executed.
        * GIVEN: Prepare inputs, mocks, expectations
        * WHEN: Call the method you are testing
        * THEN: Assert results and interactions
        * */
        ShortnerResponseDTO response = urlShortnerService.URLShortner(request);

        // THEN
        /*Did the code behave the way we expected?*/
        assertNotNull(response);
        assertEquals("abc123", response.getShortUrl());
        assertEquals("https://google.com", response.getOriginalUrl());

        /* It checks that the service actually called the repository’s save() method exactly once.*/
        verify(urlShortnerRepo, times(1)).save(any(URLShortner.class));
    }
}
