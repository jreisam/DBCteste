package com.jreis.teste.service;

import com.jreis.teste.domain.BcMsg;
import com.jreis.teste.mock.BcmsgMock;
import com.jreis.teste.repository.BcMsgRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class BcMsgServiceTest {

    @Mock
    private BcMsgRepository bcmsgRepository;

    @InjectMocks
    private BcMsgService bcMsgService;

    @Test
    public void deveEncontrarPorId() {
        long id = 1L;
        BcMsg bcMsg = BcmsgMock.getAleatorio(id);
        when(bcmsgRepository.findById(anyLong()))
                .thenReturn(Optional.of(bcMsg));
        BcMsg result = bcMsgService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void deveLancarErroSeIdNotFound() {
        when(bcmsgRepository.findById(anyLong()))
                .thenReturn(Optional.empty());
        bcMsgService.findById(1L);
    }

}
