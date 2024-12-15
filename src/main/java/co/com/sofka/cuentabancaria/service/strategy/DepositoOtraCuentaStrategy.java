package co.com.sofka.cuentabancaria.service.strategy;

import co.com.sofka.cuentabancaria.config.exceptions.ConflictException;
import co.com.sofka.cuentabancaria.model.Cuenta;

import java.math.BigDecimal;

public class DepositoOtraCuentaStrategy implements TransaccionStrategy {
    private static final BigDecimal COSTO = BigDecimal.valueOf(1.50);

    @Override
    public void validar(Cuenta cuenta, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ConflictException("El monto para un depósito a otra cuenta debe ser mayor a 0.");
        }
    }

    @Override
    public BigDecimal getCosto() {
        return COSTO;
    }
}
