//import * as React from 'react';
import { NumericTextBox } from '@progress/kendo-react-inputs';
import { NumberFormatOptions } from '@progress/kendo-react-intl';

interface MyFloatingLabelAmountInputProps {
	defaultValue: number;
}

const MyFloatingLabelAmountInput = (props: MyFloatingLabelAmountInputProps) => {
	const { defaultValue, ...others } = props;
	return (
        <NumericTextBox
          width={300}
          defaultValue={defaultValue}
          format="c2"
          min={0}
        />
	);

};

export default MyFloatingLabelAmountInput;