import * as React from 'react';
import { Form, Field, FormElement, FieldRenderProps, FormRenderProps, FieldWrapper } from '@progress/kendo-react-form';
import { Error } from '@progress/kendo-react-labels';
import { Input } from '@progress/kendo-react-inputs';
import { Button } from '@progress/kendo-react-buttons';
import MyFloatingLabelEmailInput from '../../component/field/MyFloatingLabelEmailInput';

const emailRegex: RegExp = new RegExp(/\S+@\S+\.\S+/);
const emailValidator = (value: string) => (emailRegex.test(value) ? '' : 'Please enter a valid email.');
const EmailInput = (fieldRenderProps: FieldRenderProps) => {
    const { validationMessage, visited, ...others } = fieldRenderProps;
    return (
        <div className="k-form-field-wrap">
            <Input {...others} labelClassName={'k-form-label'} />
            {visited && validationMessage && <Error>{validationMessage}</Error>}
        </div>
    );
};

const LoanView = () => {

    const handleSubmit = (dataItem: { [name: string]: any }) => alert(JSON.stringify(dataItem, null, 2));

    return (
        <Form
            onSubmit={handleSubmit}
            render={(formRenderProps: FormRenderProps) => (
				<>
                <FormElement style={{ maxWidth: 650 }} horizontal={true}>
                    	<fieldset className={'k-form-fieldset'}>
                        <legend className={'k-form-legend'}>Please fill in the fields:</legend>
                        <FieldWrapper>
                            <div className="k-form-field-wrap">
                                <Field
                                    name={'firstName'}
                                    component={Input}
                                    labelClassName={'k-form-label'}
                                    label={'First name'}
                                />
                            </div>
                        </FieldWrapper>

                        <FieldWrapper>
                            <div className="k-form-field-wrap">
                                <Field
                                    name={'lastName'}
                                    component={Input}
                                    labelClassName={'k-form-label'}
                                    label={'Last name'}
									disabled={true}
                                />
                            </div>
                        </FieldWrapper>

                        <FieldWrapper>
                            <Field
                                name={'email'}
                                type={'email'}
                                component={Input}
                                label={'Email'}
                                validator={emailValidator}
								hint={'take a hike'}
                            />
                        </FieldWrapper>
					<FieldWrapper>
						<Field
							name={'fundsDisbursementDate'}
							component={Input}
							label={'Loan Date'}
						/>
					</FieldWrapper>
                    </fieldset>
                    <div className="k-form-buttons">
                        <Button disabled={!formRenderProps.allowSubmit}>Submit</Button>
                    </div>
                </FormElement>
				</>
            )}
        />
    );
};

export default LoanView;
