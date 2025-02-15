import { Form, Field, FormElement, FieldWrapper, FieldRenderProps, FormRenderProps } from '@progress/kendo-react-form';
import { Input } from '@progress/kendo-react-inputs';
import { Label, Error, Hint, FloatingLabel } from '@progress/kendo-react-labels';

type MyDefaultFloatingLabelInputProps = {
	hint: string;
}

const defaultProps: MyDefaultFloatingLabelInputProps = {
	hint: 'Enter your personal email address.'
}

const emailRegex: RegExp = new RegExp(/\S+@\S+\.\S+/);
const emailValidator = (value: string) => (emailRegex.test(value) ? '' : 'Please enter a valid email.');

const MyFloatingLabelEmailInput = (fieldRenderProps: FieldRenderProps) => {
    const { validationMessage, visited, label, id, valid, value, disabled, ...others } = fieldRenderProps;
    const showValidationMessage = visited && validationMessage;

    return (
        <FieldWrapper>
            <div className="k-form-field-wrap">
                <FloatingLabel
                    labelClassName="k-form-label"
                    label={label}
                    editorValue={value}
                    editorValid={valid}
                    editorDisabled={disabled}
                    editorId={id}
                >
                    <Input value={value} valid={valid} type={'email'} id={id} disabled={disabled} {...others} />
                </FloatingLabel>
                {!showValidationMessage && <Hint>{defaultProps.hint}</Hint>}
                {showValidationMessage && <Error>{validationMessage}</Error>}
            </div>
        </FieldWrapper>
    );
};

export default MyFloatingLabelEmailInput;
