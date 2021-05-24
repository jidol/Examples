from random import randint

from math import log10, pow, floor


def is_palindrome_integer(request: int) -> bool:
    # Base case, early return
    if 0 > request or None is request:
        return False  # Early return, cannot work becase Neg sign

    # Number of digits
    # log10 of request says how many multiples of 10 in number add one for rounding
    number_digits: int = int(floor(log10(request))) + 1

    # Early return when only one digit
    if 1 == number_digits:
        return True

    # One result for remaining code
    final_result: bool = True

    # Loop over half the digits
    half_digits: int = number_digits // 2  # Integer divide
    number_being_processed: int = request
    first_digit_mask: int = pow(10, number_digits - 1)  # Minus 1 because we do not want full mask
    for index in range(0, half_digits):
        last_digit_in_number: int = int(number_being_processed % 10)
        first_digit: int = floor(number_being_processed / first_digit_mask)
        if last_digit_in_number != first_digit:
            final_result = False  # update result
            break  # We are done
        number_being_processed %= first_digit_mask
        number_being_processed /= 10
        first_digit_mask /= 100

    # Single return for tracing
    return final_result


def second_draft(request):
    if None is request or 0 > request:
        return False  # Negative or bad input
    number_of_digits = int(floor(log10(request))) + 1
    if 1 == number_of_digits:
        return True
    mask = int(pow(10, (number_of_digits - 1)))
    for index in range(0, number_of_digits // 2):
        first_digit = int(request % 10)
        last_digit = int(request / mask)
        if first_digit != last_digit:
            return False
        request %= mask  # Remove first digit
        request /= 10  # Remove last digit
        mask /= 100  # Move mask
    return True


if __name__ == '__main__':
    stop_range_random: int = 10000
    number_test = 50
    output = []
    failed = []
    for loop_index in range(0, number_test):
        number_to_check: int = randint(0, stop_range_random)
        if second_draft(number_to_check):
            output.append(number_to_check)
        else:
            failed.append(number_to_check)
    print("Final list:  " + str(output))
